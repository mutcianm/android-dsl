package ru.ifmo.rain.adsl

import org.objectweb.asm.tree.ClassNode
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import org.objectweb.asm.tree.MethodNode

class DSLWriter(val settings: BaseGeneratorSettings) {

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
            writeFile(containerCache, "containerBaseClass")
        if (settings.generateContainerClasses)
            writeFile(containerClassesCache, "layouts")
        if (settings.generateProperties)
            writeFile(propsCache, "properties")
        if (settings.generateUIClass)
            writeFile(uiClassCache, "uiClasses")
    }

    private fun writeFile(buffer: StringBuffer, subsystem: String) {
        val out = BufferedWriter(FileWriter(settings.getOutputFile(subsystem)))
        out.append(buffer)
        out.close()
    }

    public fun produceProperty(prop: PropertyData) {
        val propertyReturnType = prop.propType!!.toStr()
        val mutability = if (prop.setter == null) "val" else "var"
        val setterValue = if (propertyReturnType.endsWith("?")) "(value!!)" else "(value)"
        with (prop) {
            propsCache append "$mutability $className.$propName: $propertyReturnType\n"
            propsCache append "    get() = $getter()\n"
            if (setter != null)
                propsCache append "    set(value) = $setter$setterValue\n"
            propsCache append "\n"
        }
    }

    public fun genListenerHelper(methodInfo: MethodNodeWithParent) {
        val className = methodInfo.parent.cleanInternalName()
        val setter = methodInfo.child.name
        val listenerName = methodInfo.child.name!!.replace("set", "").replace("Listener", "")
        val listenerType = methodInfo.child.arguments!![0].toStr()
        listenerFunCache append "fun $className.$listenerName(l: $listenerType) {\n"
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

    public fun genContainerClass(classNode: ClassNode, layoutParams: ClassNode) {
        val cleanName = classNode.cleanName()
        containerClassesCache append "class _$cleanName"
        containerClassesCache append "(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {\n\n"
        genLayoutParams(classNode, layoutParams)
        containerClassesCache append "}\n\n"
    }

    private fun makeLayoutParam(classNode: ClassNode, cons: MethodNode) {
        val cleanName = classNode.cleanName()
        val params = cons.fmtArguments()
        val paramsInvoke = cons.fmtArgumentsInvoke()
        val separator = if(params == "") "" else ","
        containerClassesCache append "    fun android.view.View.layoutParams($params$separator init: $cleanName.LayoutParams.() -> Unit) {\n"
        containerClassesCache append "        val lp = $cleanName.LayoutParams($paramsInvoke)\n"
        containerClassesCache append "        lp.init()\n"
        containerClassesCache append "        (this: View).setLayoutParams(lp)\n    }\n\n"
    }
    public fun genLayoutParams(viewGroup: ClassNode, layoutParams: ClassNode) {
        for (cons in layoutParams.getConstructors()) {
            makeLayoutParam(viewGroup, cons)
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


