package ru.ifmo.rain.adsl;

import java.util.jar.JarEntry
import java.util.Enumeration
import java.util.jar.JarFile
import java.util.Collections
import org.objectweb.asm.*
import java.io.InputStream
import java.util.ArrayList
import java.io.OutputStream
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.TreeMap
import java.util.Arrays
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

class IgnoredClassException : Exception()

class Hook<T>(val predicate: ((_class: T) -> Boolean), val function: ((_class: T) -> Unit)) {
    public fun run(_class: T) {
        if (predicate(_class))
            function(_class)
    }

    public fun invoke(_class: T) {
        run(_class)
    }
}

class PropertyData(val className: String,
                   val propName: String,
                   var propType: Type?,
                   var getter: String?,
                   var setter: String?,
                   var valueType: Type?)

fun typeMap(str: String): String {
    return when (str) {
        "java.lang.CharSequence" -> "jet.CharSequence"
        "java.lang.String" -> "jet.String"
        "java.lang.Integer" -> "jet.Int"
        "java.lang.Object" -> "jet.Any"
        else -> str
    }
}

class Generator(val out: OutputStream, val jarPath: String, val packageName: String) {
    private val ps = BufferedWriter(OutputStreamWriter(out))
    var settings = GeneratorSettings()
        set(value) {
            $settings = value
        }

    private val propsCache = StringBuffer()
    private val containerCache = StringBuffer()
    private val containerClassesCache = StringBuffer()
    private val uiClassCache = StringBuffer()

    private val propMap = TreeMap<String, PropertyData>()

    private val classBlackList = settings.blackListedClasses
    private val propBlackList = settings.blacklistedProperties
    private val helperConstructors = settings.helperConstructors

    private val classTree: ClassTree = ClassTree()

    private val classHooks = Arrays.asList<Hook<ClassNode>>(
            Hook({
                !isBlacklistedClass(it) &&
                !it.isAbstract() &&
                !it.isInner() &&
                !isContainer(it)
            },
                    { genWidget(it) }),
            Hook({
                !isBlacklistedClass(it) &&
                !it.isAbstract() &&
                !it.isInner() &&
                isContainer(it)
            },
                    { genContainer(it) })
    )

    private val methodHooks = Arrays.asList<Hook<MethodNodeWithParent>>(
            Hook({
                it.child.isGetter() &&
                !it.child.isProtected() &&
                !it.parent.isGeneric() &&
                !it.child.isGeneric()
            }, { genGetter(it) }),
            Hook({
                it.child.isSetter() &&
                !it.child.isProtected() &&
                !it.parent.isGeneric() &&
                !it.child.isGeneric()
            }, { genSetter(it) })
    )

    private fun isBlacklistedClass(classInfo: ClassNode): Boolean {
        return classInfo.cleanInternalName() in classBlackList
    }

    private fun isBlacklistedProperty(propertyName: String): Boolean {
        return propertyName in propBlackList
    }

    private fun isContainer(widget: ClassNode): Boolean {
        return classTree.isChildOf(widget, settings.containerBaseClass)
    }

    private fun initCaches() {
        containerCache append settings.containerHeader
        uiClassCache   append settings.uiClassHeader
    }

    private fun finalizeCaches() {
        containerCache append "}\n\n"
        uiClassCache   append "}\n\n"
    }

    public fun run() {
        initCaches()
        val vg = ClassNode()
        vg.name = settings.containerBaseClass
        classTree.add(vg)
        for (classData in extractClasses(jarPath, packageName)) {
            classTree.add(processClassData(classData))
        }
        for (classInfo in classTree) {
            classInfo.methods!!.forEach { method ->
                methodHooks.forEach {
                    hook ->
                    hook(MethodNodeWithParent(classInfo, method as MethodNode))
                }
            }
            classHooks.forEach { hook -> hook(classInfo) }
        }
        finalizeCaches()
        if (settings.generatePackage) {
            ps.write(settings._package)
            ps.newLine()
        }
        if (settings.generateImports) {
            ps.write(settings.imports)
            ps.newLine()
        }
        if (settings.generateContainerBaseClass)
            produceContainerBaseClass()
        if (settings.generateProperties)
            produceProperties()
        if (settings.generateContainerClasses)
            produceContainerClasses()
        if (settings.generateUIClass)
            produceUIClass()
        if (settings.generateUIClassWrapper)
            ps.write(settings.footer)
        ps.close()
    }

    private fun genHeader() {
    }

    private fun produceContainerBaseClass() {
        ps.write(containerCache.toString())
    }

    private fun produceContainerClasses() {
        ps.write(containerClassesCache.toString())
    }

    private fun produceUIClass() {
        ps.write(uiClassCache.toString())
    }

    private fun produceProperty(prop: PropertyData) {
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

    private fun produceProperties() {
        for (prop in propMap.values()) {
            if (!isBlacklistedProperty(prop.className + '.' + prop.propName))
                if (prop.getter != null)
                    produceProperty(prop)
        }
        ps.write(propsCache.toString())
    }

    //    private fun setOrCreateProperty(prop: PropertyData) {
    //
    //    }

    private fun genSetter(methodInfo: MethodNodeWithParent) {
        if (!settings.generateSetters) return
        var className: String = methodInfo.parent.cleanInternalName()
        var setter = methodInfo.child.name
        if (isContainer(methodInfo.parent)) {
            className = "_" + methodInfo.parent.cleanName()
            setter = "(vgInstance as " + methodInfo.parent.cleanInternalName() +
            ")." + methodInfo.child.name
        }
        val prop = propMap[className + methodInfo.child.toProperty()]
        if (prop != null) {
            prop.setter = setter
            prop.valueType = methodInfo.child.arguments!![0]
        } else {
            propMap[className + methodInfo.child.toProperty()] =
            PropertyData(className, methodInfo.child.toProperty(),
                    null, null, setter, methodInfo.child.arguments!![0])
        }
    }

    private fun genGetter(methodInfo: MethodNodeWithParent) {
        if (!settings.generateGetters) return
        var className: String = methodInfo.parent.cleanInternalName()
        var getter = methodInfo.child.name
        if (isContainer(methodInfo.parent)) {
            className = "_" + methodInfo.parent.cleanName()
            getter = "(vgInstance as " + methodInfo.parent.cleanInternalName() +
            ")." + methodInfo.child.name
        }
        val prop = propMap[className + methodInfo.child.toProperty()]
        if (prop != null) {
            if (prop.getter != null)
                return
            prop.getter = getter
            prop.propType = methodInfo.child.getReturnType()
        } else {
            propMap[className + methodInfo.child.toProperty()] =
            PropertyData(className, methodInfo.child.toProperty(),
                    methodInfo.child.getReturnType(), getter, null, null)
        }
    }

    private fun getConstructors(classNode: ClassNode): List<List<PropertyData>> {
        val constructors: List<List<String>>? = helperConstructors.get(classNode.cleanInternalName())
        val res = ArrayList<ArrayList<PropertyData>>()
        val emptyConstructor = ArrayList<PropertyData>()
        res.add(emptyConstructor)
        val className = classNode.cleanInternalName()
        if (constructors == null || !settings.generateHelperConstructors) {
            return res
        } else {
            for (constructor in constructors) {
                val cons = ArrayList<PropertyData>()
                for (argument in constructor) {
                    val _class = classTree.findParentWithProperty(classNode, argument)
                    if (_class == null)
                        throw RuntimeException("Property $argument is not in $className hierarchy")
                    val property = propMap.get(_class.cleanInternalName() + argument)
                    if (property == null)
                        throw RuntimeException("Property $argument in not a member of $className")
                    if (property.valueType == null)
                        throw RuntimeException("Property $argument is read-only in $className")
                    cons.add(property)
                }
                res.add(cons)
            }
            return res
        }
    }

    private fun makeWidget(className: String,
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

    private fun genWidget(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanInternalName = classNode.cleanInternalName()
        val constructors = getConstructors(classNode)
        for (constructor in constructors) {
            makeWidget(cleanNameDecap, cleanInternalName, constructor)
        }
    }

    private fun genContainer(classNode: ClassNode) {
        genContainerWidgetFun(classNode)
        genContainerClass(classNode)
        genUIWidgetFun(classNode)
    }

    private fun makeContainerWidgetFun(cleanNameDecap: String,
                                       cleanName: String,
                                       cleanInternalName: String,
                                       args: String) {
        containerCache append "    //container function\n"
        containerCache append "    fun $cleanNameDecap( init: _$cleanName.() -> Unit): _$cleanName {\n"
        containerCache append "        val v = _$cleanName($cleanInternalName(ctx), ctx)\n"
        containerCache append "        v.init()\n"
        containerCache append "        vgInstance.addView(v.vgInstance)\n"
        containerCache append "        _style(v)\n"
        containerCache append "        return v\n    }\n\n"
    }

    private fun genContainerWidgetFun(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        makeContainerWidgetFun(cleanNameDecap, cleanName, cleanInternalName, "")
    }

    private fun genContainerClass(classNode: ClassNode) {
        val cleanName = classNode.cleanName()
        containerClassesCache append "class _$cleanName"
        containerClassesCache append "(override val vgInstance: android.view.ViewGroup, override val ctx: android.app.Activity): _Container(vgInstance, ctx) {\n"
        containerClassesCache append "\n}\n\n"
    }

    private fun genUIWidgetFun(classNode: ClassNode) {
        val cleanNameDecap = classNode.cleanNameDecap()
        val cleanName = classNode.cleanName()
        val cleanInternalName = classNode.cleanInternalName()
        uiClassCache append "    fun $cleanNameDecap(init: _$cleanName.() -> Unit) {\n"
        uiClassCache append "        val layout = _$cleanName($cleanInternalName(act), act)\n"
        uiClassCache append "        layout.init()\n"
        uiClassCache append "        act.setContentView(layout.vgInstance)\n    }\n\n"
    }


    private fun processClassData(classData: InputStream?): ClassNode {
        val cn = ClassNode()
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: IgnoredClassException) {
            //optionally log something here
        } finally {
            classData?.close()
        }
        return cn
    }


    private fun extractClasses(jarPath: String, packageName: String): Iterator<InputStream> {
        val packageName = packageName.replace('.', '/')
        val jarFile = JarFile(jarPath)
        return Collections.list(jarFile.entries() as Enumeration<JarEntry>)
                .iterator()
                .filter { it.getName().startsWith(packageName) && it.getName().endsWith(".class") }
                .map {
            jarFile.getInputStream(it)!!
        }
    }

}




