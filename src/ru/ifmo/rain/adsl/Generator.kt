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

class IgnoredClassEx : Exception()

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
                   var arg: Type?)

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
    val ps = BufferedWriter(OutputStreamWriter(out))
    val settings = GeneratorSettings()

    val propsCache = StringBuffer()
    val containerCache = StringBuffer()
    val containerClassesCache = StringBuffer()
    val uiClassCache = StringBuffer()

    val propMap = TreeMap<String, PropertyData>()

    val classBlackList = settings.getBlackListedClasses()
    val propBlackList = settings.getBlackListedProperties()

    val classTree: ClassTree = ClassTree()

    val classHooks = Arrays.asList<Hook<ClassNode>>(
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

    val methodHooks = Arrays.asList<Hook<MethodNodeWithParent>>(
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
        return classTree.isChildOf(widget, settings.getContainerBaseClass())
    }

    private fun initCaches() {
        containerCache append settings.getContainerHeader()
        uiClassCache   append settings.getUIClassHeader()
    }

    private fun finalizeCaches() {
        containerCache append "}\n\n"
        uiClassCache   append "}\n\n"
    }

    public fun run() {
        initCaches()
        val vg = ClassNode()
        vg.name = settings.getContainerBaseClass()
        classTree.add(vg)
        for (classData in extractClasses(jarPath, packageName)) {
            classTree.add(processClassData(classData))
        }
        for (classInfo in classTree) {
            classHooks.forEach { hook -> hook(classInfo) }
            classInfo.methods!!.forEach { method ->
                methodHooks.forEach {
                    hook ->
                    hook(MethodNodeWithParent(classInfo, method as MethodNode))
                }
            }
        }
        finalizeCaches()
        genHeader()
        produceContainerBaseClass()
        produceProperties()
        produceContainerClasses()
        produceUIClass()
        ps.write(settings.getFooter())
        ps.close()
    }

    private fun genHeader() {
        ps.write(settings.getPackage())
        ps.newLine()
        ps.write(settings.getImports())
        ps.newLine()
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

    private fun produceProperties() {
        propMap.values().forEach {
            if (!isBlacklistedProperty(it.className + '.' + it.propName)) {
                if (it.getter != null) {
                    propsCache append if (it.setter == null) "val " else "var "
                    propsCache append it.className
                    propsCache append '.'
                    propsCache append it.propName
                    propsCache append ": "
                    propsCache append it.propType!!.toStr()
                    propsCache append '\n'
                    propsCache append "\tget() = this."
                    propsCache append it.getter
                    propsCache append "()\n"
                    if (it.setter != null) {
                        propsCache append "\tset(value) = "
                        propsCache append it.setter
                        propsCache append "(value) \n\n"
                    } else {
                        propsCache append "\n"
                    }
                }
            }
        }

        ps.write(propsCache.toString())
    }

    private fun genSetter(methodInfo: MethodNodeWithParent) {
        val prop = propMap[methodInfo.parent.name + methodInfo.child.toProperty()]
        if (prop != null) {
            prop.setter = methodInfo.child.name
            prop.arg = methodInfo.child.arguments!![0]
        } else {
            propMap[methodInfo.parent.name + methodInfo.child.toProperty()] =
            PropertyData(methodInfo.parent.cleanInternalName(), methodInfo.child.toProperty(),
                    null, null, methodInfo.child.name, methodInfo.child.arguments!![0])
        }
    }

    private fun genGetter(methodInfo: MethodNodeWithParent) {
        val prop = propMap[methodInfo.parent.name + methodInfo.child.toProperty()]
        if (prop != null) {
            if (prop.getter != null)
                return
            prop.getter = methodInfo.child.name
            prop.propType = methodInfo.child.getReturnType()
        } else {
            propMap[methodInfo.parent.name + methodInfo.child.toProperty()] =
            PropertyData(methodInfo.parent.cleanInternalName(), methodInfo.child.toProperty(),
                    methodInfo.child.getReturnType(), methodInfo.child.name, null, null)
        }
    }

    private fun genWidget(classNode: ClassNode) {
        containerCache append "\tfun "
        containerCache append classNode.cleanNameDecap()
        containerCache append "( init: " + classNode.cleanInternalName() + ".() -> Unit): " + classNode.cleanInternalName() + " {\n"
        containerCache append "\t\tval v = " + classNode.cleanInternalName() + "(ctx)\n"
        containerCache append "\t\tv.init()\n"
        containerCache append "\t\tvgInstance.addView(v)\n"
        containerCache append "\t\t_style(v)\n"
        containerCache append "\t\treturn v\n\t}\n\n"
    }

    private fun genContainer(classNode: ClassNode) {
        genContainerWidgetFun(classNode)
        genContainerClass(classNode)
        genUIWidgetFun(classNode)
    }

    private fun genContainerWidgetFun(classNode: ClassNode) {
        containerCache append "\t//container function\n"
        containerCache append "\tfun "
        containerCache append classNode.cleanNameDecap()
        containerCache append "\t( init: _"
        containerCache append classNode.cleanName()
        containerCache append ".() -> Unit): _"
        containerCache append classNode.cleanName()
        containerCache append " {\n"
        containerCache append "\t\tval v = _"
        containerCache append classNode.cleanName()
        containerCache append  "("
        containerCache append classNode.cleanInternalName()
        containerCache append "(ctx), ctx)\n"
        containerCache append "\t\tv.init()\n"
        containerCache append "\t\tvgInstance.addView(v.vgInstance)\n"
        containerCache append "\t\t_style(v)\n"
        containerCache append "\t\treturn v\n\t}\n\n"
    }

    private fun genContainerClass(classNode: ClassNode) {
        containerClassesCache append "class _"
        containerClassesCache append  classNode.cleanName()
        containerClassesCache append "(val vgInstance: android.view.ViewGroup, val ctx: android.app.Activity) {\n"
        containerClassesCache append "\n}\n\n"
    }

    private fun genUIWidgetFun(classNode: ClassNode) {
        uiClassCache append "\tfun "
        uiClassCache append classNode.cleanNameDecap()
        uiClassCache append "(init: _"
        uiClassCache append classNode.cleanName()
        uiClassCache append ".() -> Unit) {\n\t\tval layout = _"
        uiClassCache append classNode.cleanName()
        uiClassCache append "("
        uiClassCache append classNode.cleanInternalName()
        uiClassCache append "(act), act)\n\t\tlayout.init()\n"
        uiClassCache append "\t\tact.setContentView(layout.vgInstance)\n\t}\n\n"
    }


    private fun processClassData(classData: InputStream?): ClassNode {
        val cn = ClassNode()
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: IgnoredClassEx) {
            //optionally log something here
        } finally {
            classData?.close()
        }
        return cn
    }

    private fun extractClasses(jarPath: String, packageName: String): ArrayList<InputStream?> {
        val packageName = packageName.replace('.', '/')
        val jarFile = JarFile(jarPath)
        var entries: jet.List<JarEntry> = Collections.list(jarFile.entries() as Enumeration<JarEntry>)
        entries = entries.filter { it.getName().startsWith(packageName) && it.getName().endsWith(".class") }
        var ret = arrayListOf<InputStream?>()
        return entries.mapTo(ret) { jarFile.getInputStream(it) }
    }
}




