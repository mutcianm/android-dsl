package ru.ifmo.rain.adsl

import org.objectweb.asm.tree.ClassNode
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import org.objectweb.asm.tree.MethodNode

class DSLWriter(val settings: BaseGeneratorSettings) {


    val kotlin_keywords = "val var import package fun type class object super public private protected return " +
    "trait where this namespace try catch throw if else while do for break continue return true false null " +
    "abstract final enum open attribute override open final abstract internal in out ref lazy"

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

    public fun produceProperty(prop: PropertyData) {
//        if ((prop.setter != null) && prop.propType != prop.valueType) {
//            System.err.println("Property "+ prop.propName+" setter type != getter type: " + prop.propType?.toStr() + " != "+ prop.valueType?.toStr() )
//            return
//        }
        val propertyReturnType = prop.propType!!.toStr()
        val mutability = if (prop.setter == null) "val" else "var"
        val setterValue = if (propertyReturnType.endsWith("?")) "(value!!)" else "(value)"
        if (prop.propName in keywordSet)
            prop.propName = "_"+ prop.propName
        with (prop) {
            propsCache append "$mutability $className.$propName: $propertyReturnType\n"
            propsCache append "    get() = $getter()\n"
            if (setter != null)
                propsCache append "    set(value) = $setter$setterValue\n"
            propsCache append "\n"
        }
    }

    public fun genListenerHelper(view: MethodNodeWithParent, lp: ClassNode) {
        val methods = lp.methods?.filter { (it as MethodNode).name != "<init>" }
        if (methods != null && (methods.size() != 1)) {
//            System.err.println("Unsupported number of methods in " + lp.name + ": " + lp.methods?.size)
            return
        }
        val parentClassName = view.parent.cleanInternalName()
        val setter = view.child.name
        val listenerName = decapitalize(view.child.name!!.replace("set", "").replace("Listener", ""))
        val method = methods!![0] as MethodNode
        if (method.signature != null) {
//            System.err.println("Generic methods are unsupported: " + method.signature)
            return
        }
        val listenerArgumentTypes = method.fmtArgumentsTypes()
        val listenerReturnType = method.getReturnType().toStr()
                listenerFunCache append "fun $parentClassName.$listenerName(l: ($listenerArgumentTypes) -> $listenerReturnType) {\n"
                listenerFunCache append "    $setter(l)\n}\n"
    }

    public fun makeWidget(className: String,
                           internalName: String,
                           arguments: List<PropertyData>) {
        val args = StringBuilder()
        arguments.forEach {
            args append it.propName
            args append ": "
            args append it.propType!!.toStr()
            args append ", "
        }
        val strArgs = args.toString()
        containerCache append "    fun $className($strArgs init: $internalName.() -> Unit): $internalName {\n"
        containerCache append "        val v = $internalName(ctx)\n"
        for (arg in arguments) {
            val argName = arg.propName
            containerCache append "        v.$argName = $argName\n"
        }
        containerCache append "        v.init()\n"
        containerCache append "        vgInstance.addView(v)\n"
        containerCache append "        _style(v)\n"
        containerCache append "        return v\n    }\n\n"
    }

    public fun makeContainerWidgetFun(cleanNameDecap: String,
                                      cleanName: String,
                                      cleanInternalName: String) {
        containerCache append "    //container function\n"
        containerCache append "    fun $cleanNameDecap( init: _$cleanName.() -> Unit): _$cleanName {\n"
        containerCache append "        val v = _$cleanName($cleanInternalName(ctx), ctx)\n"
        containerCache append "        v.init()\n"
        containerCache append "        vgInstance.addView(v.vgInstance)\n"
        containerCache append "        _style(v)\n"
        containerCache append "        return v\n    }\n\n"
    }

    public fun genContainerClass(classNode: ClassNode, layoutParams: ClassNode?) {
        val cleanName = classNode.cleanName()
        containerClassesCache append "class _$cleanName"
        containerClassesCache append "(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {\n\n"
        if (layoutParams != null)
            genLayoutParams(classNode, layoutParams)
        containerClassesCache append "}\n\n"
    }

    private fun makeLayoutParam(classNode: ClassNode, layoutParams: ClassNode, cons: MethodNode) {
        val cleanName = layoutParams.cleanInternalName()
        val params = cons.fmtArguments()
        val paramsInvoke = cons.fmtArgumentsInvoke()
        val separator = if(params == "") "" else ","
        containerClassesCache append "    fun android.view.View.layoutParams($params$separator init: $cleanName.() -> Unit) {\n"
        containerClassesCache append "        val lp = $cleanName($paramsInvoke)\n"
        containerClassesCache append "        lp.init()\n"
        containerClassesCache append "        (this: View).setLayoutParams(lp)\n    }\n\n"
    }
    public fun genLayoutParams(viewGroup: ClassNode, layoutParams: ClassNode) {
        for (cons in layoutParams.getConstructors()) {
            makeLayoutParam(viewGroup, layoutParams, cons)
        }
    }

    public fun genUIWidgetFun(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        uiClassCache append "    fun $cleanNameDecap(init: _$cleanName.() -> Unit) {\n"
        uiClassCache append "        val layout = _$cleanName($cleanInternalName(act), act)\n"
        uiClassCache append "        layout.init()\n"
        uiClassCache append "        act.setContentView(layout.vgInstance)\n    }\n\n"
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


