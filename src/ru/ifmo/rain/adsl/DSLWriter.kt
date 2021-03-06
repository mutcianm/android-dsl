package ru.ifmo.rain.adsl

import org.objectweb.asm.tree.ClassNode
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import org.objectweb.asm.tree.MethodNode

open class DSLWriterException(message: String) : DSLException(message)
open class InvalidListenerException(message: String) : DSLWriterException(message)

class DSLWriter(val settings: BaseGeneratorSettings, val classTree: ClassTree) {


    private val kotlin_keywords = "val var import package fun type class object super public private protected return " +
    "trait where this namespace try catch throw if else while do for break continue return true false null " +
    "abstract final enum open attribute override open final abstract internal in out ref lazy when"

    private val keywordSet = kotlin_keywords.split(" ").toSet()

    private val propsCache = StringBuffer()
    private val containerCache = StringBuffer()
    private val containerClassesCache = StringBuffer()
    private val uiClassCache = StringBuffer()
    private val listenerFunCache = StringBuffer();

    //cons
    {
        initCaches()
        File(settings.dslPath).mkdirs()
    }

    public fun write() {
        finalizeCaches()
        if (settings.generateContainerBaseClass)
            writeFile(containerCache, Subsystems.CONTAINER_BASE_CLASS)
        if (settings.generateContainerClasses)
            writeFile(containerClassesCache, Subsystems.LAYOUTS)
        if (settings.generateProperties)
            writeFile(propsCache, Subsystems.PROPERTIES)
        if (settings.generateUIClass)
            writeFile(uiClassCache, Subsystems.UI_CLASS)
        if (settings.generateListenerHelpers)
            writeFile(listenerFunCache, Subsystems.LISTENER_HELPERS)
    }

    private fun writeFile(buffer: StringBuffer, subsystem: Subsystems) {
        val out = BufferedWriter(FileWriter(settings.getOutputFile(subsystem)))
        out.append(buffer)
        out.close()
    }

    private fun fixIdentName(name: String): String {
        if (name in keywordSet || name.charAt(0).isDigit())
            return "_$name"
        else
            return name
    }

    private fun fixListenerMethodArgs(key: String, defaultArgs: String): String {
        return when(key) {
//                    "OnSeekBarChangeListeneronProgressChanged" -> "p0: android.widget.SeekBar, p1: Int, p2: Boolean"
//                    "OnSeekBarChangeListeneronStopTrackingTouch" -> "p0: android.widget.SeekBar"
//                    "OnScrollListeneronScroll" -> "p0: android.widget.AbsListView, p1: Int, p2: Int, p3: Int"
            else -> defaultArgs
        }
    }

    private fun isWidget(classNode: ClassNode): Boolean {
        return classTree.isSuccessorOf(classNode, settings.widgetBaseClass)
    }

    private fun isContainer(widget: ClassNode): Boolean {
        return classTree.isSuccessorOf(widget, settings.containerBaseClass)
    }

    public fun produceProperty(prop: PropertyData) {
        var c = Context(propsCache)
        val className: String
        val setterName: String
        val getterName: String
        if (prop.isContainer) {
            className = "_${prop.parentClass.cleanName()}"
            setterName = if (prop.setter != null) "viewGroup." + prop.setter!!.name else ""
            getterName = if (prop.getter != null) "viewGroup." + prop.getter!!.name else ""
        } else {
            className = prop.parentClass.cleanInternalName()
            setterName = if (prop.setter != null)  prop.setter!!.name!! else ""
            getterName = if (prop.getter != null)  prop.getter!!.name!! else ""
        }
        val propertyReturnType = prop.getter!!.renderReturnType()
        val mutability = if (prop.setter == null) "val" else "var"
        val setterValue = if (propertyReturnType.endsWith("?")) "(value!!)" else "(value)"
        prop.propName = fixIdentName(prop.propName)
        with (prop) {
            c.writeln("$mutability $className.$propName: $propertyReturnType")
            c.incIndent()
            c.writeln("get() = $getterName()")
            if (setter != null)
                c.writeln("set(value) = $setterName$setterValue")
        }
        c.newLine()
    }

    private fun makeListenerHelper(cont: Context, view: MethodNodeWithParent, listener: ClassNode) {
        val methods = listener.methods?.filter { it.name != "<init>" }
        val parentClassName = view.parent.cleanInternalName()
        val setter = view.child.name
        val listenerName = decapitalize(view.child.name!!.replace("set", "").replace("Listener", ""))
        val method = methods!![0]
        val listenerArgumentTypes = method.fmtArgumentsTypes()
        val listenerReturnType = method.getReturnType().toStr()
        cont.writeln("fun $parentClassName.$listenerName(l: ($listenerArgumentTypes) -> $listenerReturnType) {")
        cont.incIndent()
        cont.writeln("$setter(l)")
        cont.decIndent()
        cont.writeln("}\n")
    }

    private fun makeEmptyMethodInitializer(method: MethodNode): String {
        return "{ ${method.fmtArgumentsNames()} -> ${method.getReturnType().getDefaultValue()} }"
    }

    private fun makeListenerObject(cont: Context, view: MethodNodeWithParent, listener: ClassNode) {
        val methods = listener.methods?.filter { it.name != "<init>" }
        val parentClassName = view.parent.cleanInternalName()
        val wrapperClassName = "__${view.parent.cleanName()}${listener.cleanName()}"
        cont.writeln("class $wrapperClassName {")
        //generate helper class
        cont.incIndent()
        for (method in methods!!) {
            val propType = "(${method.fmtArguments()}) -> ${method.getReturnType().toStr()}"
            val propInitializer = makeEmptyMethodInitializer(method)
            cont.writeln("var _${method.name}: $propType = $propInitializer")
            cont.writeln("fun ${method.name}(f : $propType) { _${method.name} = f }")
        }
        cont.decIndent()
        cont.writeln("}\n")
        //generate extension function
        if (isWidget(view.parent)) {
            for (method in methods) {
                val containerContext = Context(containerCache, 1)
                val listenerArgumentTypes = method.fmtArgumentsTypes()
                val listenerReturnType = method.getReturnType().toStr()
                val listenerMethodName = decapitalize(method.name!!.replace("set", "").replace("Listener", ""))
                val listenerKey = "$parentClassName${listener.cleanName()}"
                containerContext.writeln("fun $parentClassName.$listenerMethodName(l: ($listenerArgumentTypes) -> $listenerReturnType) {")
                containerContext.incIndent()
                containerContext.writeln("var listenerClass = listenerMap.get(\"$listenerKey\") as? $wrapperClassName")
                containerContext.writeln("if (listenerClass == null) {")
                containerContext.incIndent()
                containerContext.writeln("listenerClass = $wrapperClassName()")
                containerContext.decIndent()
                containerContext.writeln("}") //if
                containerContext.writeln("listenerClass!!._${method.name} = l")
                containerContext.writeln("listenerMap.put(\"$listenerKey\", listenerClass)")
                containerContext.writeln("val lambdas = listenerLambdasMap.getOrPut(\"$parentClassName\", { ArrayList() })")
                containerContext.writeln("lambdas.add({")
                containerContext.incIndent()
                containerContext.writeln("val wrapper = listenerMap.get(\"$listenerKey\") as? $wrapperClassName")
                containerContext.writeln("if (wrapper != null) {")
                containerContext.incIndent()
                genListenerHelperWrapper(containerContext, listener, methods)
                containerContext.writeln("${view.child.name}(listener)")
                containerContext.writeln("}") // if
                containerContext.decIndent()
                containerContext.writeln("})") //setTag(2, ...
                containerContext.decIndent()
                containerContext.writeln("}\n")
            }
        } else {
            val listenerName = decapitalize(view.child.name!!.replace("set", "").replace("Listener", ""))
            cont.writeln("fun $parentClassName.$listenerName(init: $wrapperClassName.() -> Unit) {")
            cont.incIndent()
            cont.writeln("val wrapper = $wrapperClassName()")
            cont.writeln("wrapper.init()")
            genListenerHelperWrapper(cont, listener, methods)
            cont.writeln("${view.child.name}(listener)")
            cont.decIndent()
            cont.writeln("}\n")
        }
    }

    private fun genListenerHelperWrapper(cont: Context, listener: ClassNode, methods: List<MethodNode>) {
        val objectConsArgs = listener.methods!!.find { it.isConstructor() }?.fmtArguments()
        val objectCons = if (objectConsArgs != null) "($objectConsArgs)" else ""
        cont.writeln("val listener = object: ${listener.cleanInternalName()}$objectCons {")
        cont.incIndent()
        for (method in methods) {
            val returnType = method.getReturnType().toStr()
            val returnTerm = if (returnType == "jet.Unit") "" else ": $returnType"
            val returnStmt = if (returnType == "jet.Unit") "" else "return "
            val methodArgs = fixListenerMethodArgs(listener.cleanName() + method.name, method.fmtArguments())
            cont.writeln("override fun ${method.name}(${methodArgs})$returnTerm {")
            cont.incIndent()
            //FIXME: incorrect assertion checks, again
            cont.writeln("${returnStmt}wrapper!!._${method.name}(${method.fmtArgumentsInvoke()})")
            cont.decIndent()
            cont.writeln("}")
        }
        cont.decIndent()
        cont.writeln("}")
    }

    public fun genListenerHelper(view: MethodNodeWithParent, listener: ClassNode) {
        val cont = Context(listenerFunCache)
        val methods = listener.methods?.filter { it.name != "<init>" }
        if (methods == null)
            throw InvalidListenerException("Listener ${listener.name} has no listener methods")
        if (methods.size() == 1) {
            makeListenerHelper(cont, view, listener)
        } else {
            makeListenerObject(cont, view, listener)
        }
    }

    class DCons(val decl: String = "", val inv: String = "")

    private fun getNonDefaultCons(node: ClassNode): DCons {
        //extract basic constructor and its arguments
        val csdf = node.getConstructors().filterNot { it.arguments!!.size == 1 && it.arguments!![0].toStr() == "android.content.Context?" }
        //if trivial constructor not found
        return if (csdf.size() == node.getConstructors().size())
            DCons(csdf.head!!.fmtArguments("android.content.Context?") + ", ",
            ", " + csdf.head!!.fmtArgumentsInvoke("android.content.Context?"))
        else DCons()
    }

    public fun makeWidget(classNode: ClassNode,
                          className: String,
                          internalName: String,
                          arguments: List<PropertyData>) {
        var cont = Context(containerCache, 1)
        val args = StringBuilder()
        val dc = getNonDefaultCons(classNode)
        arguments.forEach {
            args append "${it.propName}: ${it.propType!!.toStr()}, "
        }
        val strArgs = args.toString()
        cont.writeln("fun $className(${dc.decl}$strArgs init: $internalName.() -> Unit): $internalName {")
        cont.incIndent()
        cont writeln "val v = $internalName(ctx${dc.inv})"
        for (arg in arguments)
            cont.writeln("v.${arg.propName} = ${arg.propName}")
        cont.writeln("v.init()")
        cont.writeln("viewGroup.addView(v)")
        cont.writeln("_style(v)")
        cont.writeln("listenerLambdasMap.get(\"$internalName\")?.forEach { it() }")
        cont.writeln("return v")
        cont.decIndent()
        cont.writeln("}\n")
    }

    public fun makeContainerWidgetFun( classNode: ClassNode,
                                       cleanNameDecap: String,
                                      cleanName: String,
                                      cleanInternalName: String) {
        var cont = Context(containerCache, 1)
        val dc = getNonDefaultCons(classNode)
        cont.writeln("//container function")
        cont.writeln("fun $cleanNameDecap(${dc.decl} init: _$cleanName.() -> Unit): _$cleanName {")
        cont.incIndent()
        cont.writeln("val v = _$cleanName($cleanInternalName(ctx${dc.inv}), ctx)")
        cont.writeln("v.init()")
        cont.writeln("viewGroup.addView(v.viewGroup)")
        cont.writeln("_style(v)")
        cont.writeln("listenerLambdasMap.get(\"$cleanInternalName\")?.forEach { it() }")
        cont.writeln("v.listenerMap.clear()")
        cont.writeln("v.listenerLambdasMap.clear()")
        cont.writeln("return v")
        cont.decIndent()
        cont.writeln("}\n")
    }

    public fun genContainerClass(classNode: ClassNode, layoutParams: ClassNode?) {
        val cont = Context(containerClassesCache)
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        cont.write("class _$cleanName")
        cont.writeln("(viewGroup: $cleanInternalName, ctx: android.app.Activity): _Container<$cleanInternalName>(viewGroup, ctx) {")
        cont.newLine()
        if (layoutParams != null)
            genLayoutParams(cont, classNode, layoutParams)
        cont.writeln("}\n")
    }

    private fun makeLayoutParam(c: Context, classNode: ClassNode, layoutParams: ClassNode, cons: MethodNode) {
        val cleanName = layoutParams.cleanInternalName()
        val params = cons.fmtArguments()
        val paramsInvoke = cons.fmtArgumentsInvoke()
        val separator = if (params == "") "" else ","
        c.writeln("fun android.view.View.layoutParams($params$separator init: $cleanName.() -> Unit = { }) {")
        c.incIndent()
        c.writeln("val lp = $cleanName($paramsInvoke)")
        c.writeln("lp.init()")
        c.writeln("this@layoutParams.setLayoutParams(lp)")
        c.decIndent()
        c.writeln("}\n")
    }
    public fun genLayoutParams(c: Context, viewGroup: ClassNode, layoutParams: ClassNode) {
        c.incIndent()
        for (cons in layoutParams.getConstructors()) {
            makeLayoutParam(c, viewGroup, layoutParams, cons)
        }
        c.decIndent()
    }

    public fun genUIWidgetFun(classNode: ClassNode) {
        val c = Context(uiClassCache)
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        val dc = getNonDefaultCons(classNode)
        c.writeln("fun android.app.Activity.$cleanNameDecap(${dc.decl}init: _$cleanName.() -> Unit) {")
        c.incIndent()
        c.writeln("val layout = _$cleanName($cleanInternalName(this${dc.inv}), this)")
        c.writeln("layout.init()")
        c.writeln("setContentView(layout.viewGroup)")
        c.decIndent()
        c.writeln("}\n")
    }

    private fun initCaches() {
        val caches = array(propsCache, containerCache,
                containerClassesCache, uiClassCache,
                listenerFunCache)
        for (cache in caches) {
            if (settings.generatePackage) {
                cache append settings._package
                cache append "\n\n"
            }
            if (settings.generateImports) {
                cache append settings.imports
                cache append "\n\n"
            }
        }
        containerCache append settings.containerHeader
    }

    private fun finalizeCaches() {
        if (settings.generateUIClassWrapper)
            uiClassCache append settings.footer
        containerCache append "}\n\n"
    }
}


