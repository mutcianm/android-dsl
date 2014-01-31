package ru.ifmo.rain.adsl

import org.objectweb.asm.tree.ClassNode
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.util.TraceSignatureVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.signature.SignatureReader

open class DSLWriterException(message: String): DSLException(message)
open class InvalidListenerException(message: String): DSLWriterException(message)
open class InvalidIndent(num: Int): DSLWriterException("Indentation level < 0: $num")

class DSLWriter(val settings: BaseGeneratorSettings) {


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
            //FIXME: nullability inference bug in kotlinc?
//            "OnSeekBarChangeListeneronProgressChanged" -> "p0: android.widget.SeekBar, p1: Int, p2: Boolean"
//            "OnSeekBarChangeListeneronStopTrackingTouch" -> "p0: android.widget.SeekBar"
//            "OnScrollListeneronScroll" -> "p0: android.widget.AbsListView, p1: Int, p2: Int, p3: Int"
            else -> defaultArgs
        }
    }

    public fun produceProperty(prop: PropertyData) {
        var c = Context(propsCache)
        val className: String
        if (prop.isContainer) {
            className = "_${prop.parentClass.cleanName()}"
            if (prop.setter != null) prop.setter = "vgInstance." + prop.setter
            if (prop.getter != null) prop.getter = "vgInstance." + prop.getter
        } else {
            className = prop.parentClass.cleanInternalName()
        }
        val propertyReturnType = prop.propType!!.toStr()
        val mutability = if (prop.setter == null) "val" else "var"
        val setterValue = if (propertyReturnType.endsWith("?")) "(value!!)" else "(value)"
        prop.propName = fixIdentName(prop.propName)
        with (prop) {
            c.writeln("$mutability $className.$propName: $propertyReturnType")
            c.incIndent()
            c.writeln("get() = $getter()")
            if (setter != null)
                c.writeln("set(value) = $setter$setterValue")
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

    private fun makeListenerObject(cont: Context, view: MethodNodeWithParent, listener: ClassNode) {
        val methods = listener.methods?.filter { it.name != "<init>" }
        val wrapperClassName = "__${view.parent.cleanName()}${listener.cleanName()}"
        cont.writeln("class $wrapperClassName {")
        //generate helper class
        cont.incIndent()
        for (method in methods!!) {
            val propType = "(${method.fmtArguments()}) -> ${method.getReturnType().toStr()}"
            val propInitializer = "{ ${method.fmtArgumentsNames()} -> throw RuntimeException(\"Method not overriden\") }"
            cont.writeln("var _${method.name}: $propType = $propInitializer")
            cont.writeln("fun ${method.name}(f : $propType) { _${method.name} = f }")
        }
        cont.decIndent()
        cont.writeln("}\n")
        //generate extension function
        val parentClassName = view.parent.cleanInternalName()
        val listenerName = decapitalize(view.child.name!!.replace("set", "").replace("Listener", ""))
        val objectConsArgs = listener.methods!!.find { it.isConstructor() }?.fmtArguments()
        val objectCons = if (objectConsArgs != null) "($objectConsArgs)" else ""
        cont.writeln("fun $parentClassName.$listenerName(init: $wrapperClassName.() -> Unit) {")
        cont.incIndent()
        cont.writeln("val wrapper = $wrapperClassName()")
        cont.writeln("wrapper.init()")
        cont.writeln("val listener = object: ${listener.cleanInternalName()}$objectCons {")
        cont.incIndent()
        for (method in methods) {
            val returnType = method.getReturnType().toStr()
            val returnTerm = if(returnType == "jet.Unit") "" else ": $returnType"
            val returnStmt = if(returnType == "jet.Unit") "" else "return "
            val methodArgs = fixListenerMethodArgs(listener.cleanName()+method.name, method.fmtArguments())
            cont.writeln("override fun ${method.name}(${methodArgs})$returnTerm {")
            cont.incIndent()
            cont.writeln("${returnStmt}wrapper._${method.name}(${method.fmtArgumentsInvoke()})")
            cont.decIndent()
            cont.writeln("}")
        }
        cont.decIndent()
        cont.writeln("}")
        cont.writeln("${view.child.name}(listener)")
        cont.decIndent()
        cont.writeln("}\n")
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

    public fun makeWidget(className: String,
                           internalName: String,
                           arguments: List<PropertyData>) {
        var cont = Context(containerCache, 1)
        val args = StringBuilder()
        arguments.forEach {
            args append "${it.propName}: ${it.propType!!.toStr()}, "
        }
        val strArgs = args.toString()
        cont.writeln("fun $className($strArgs init: $internalName.() -> Unit): $internalName {")
        cont.incIndent()
        cont writeln "val v = $internalName(ctx)"
        for (arg in arguments)
            cont.writeln("v.${arg.propName} = ${arg.propName}")
        cont.writeln("v.init()")
        cont.writeln("vgInstance.addView(v)")
        cont.writeln("_style(v)")
        cont.writeln("return v")
        cont.decIndent()
        cont.writeln("}\n")
    }

    public fun makeContainerWidgetFun(cleanNameDecap: String,
                                      cleanName: String,
                                      cleanInternalName: String) {
        var cont = Context(containerCache, 1)
        cont.writeln("//container function")
        cont.writeln("fun $cleanNameDecap( init: _$cleanName.() -> Unit): _$cleanName {")
        cont.incIndent()
        cont.writeln("val v = _$cleanName($cleanInternalName(ctx), ctx)")
        cont.writeln("v.init()")
        cont.writeln("vgInstance.addView(v.vgInstance)")
        cont.writeln("_style(v)")
        cont.writeln("return v")
        cont.decIndent()
        cont.writeln("}\n")
    }

    public fun genContainerClass(classNode: ClassNode, layoutParams: ClassNode?) {
        val cont = Context(containerClassesCache)
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        cont.write("class _$cleanName")
        cont.writeln("(vgInstance: $cleanInternalName, ctx: android.app.Activity): _Container<$cleanInternalName>(vgInstance, ctx) {")
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
        c.writeln("fun android.view.View.layoutParams($params$separator init: $cleanName.() -> Unit) {")
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
        val c = Context(uiClassCache, 1)
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        c.writeln("fun $cleanNameDecap(init: _$cleanName.() -> Unit) {")
        c.incIndent()
        c.writeln("val layout = _$cleanName($cleanInternalName(act), act)")
        c.writeln("layout.init()")
        c.writeln("act.setContentView(layout.vgInstance)")
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
            if (settings.generateImports){
                cache append settings.imports
                cache append "\n\n"
            }
        }
        containerCache append settings.containerHeader
        uiClassCache   append settings.uiClassHeader
    }

    private fun finalizeCaches() {
        uiClassCache   append "}\n\n"
        if (settings.generateUIClassWrapper)
                uiClassCache append settings.footer
        containerCache append "}\n\n"
    }
}


