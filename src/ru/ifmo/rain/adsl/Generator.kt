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
    val containerClassCache = StringBuffer()

    val propMap = TreeMap<String, PropertyData>()

    val classBlackList = settings.getBlackListedClasses()
    val propBlackList = settings.getBlackListedProperties()

    val classHooks = Arrays.asList<Hook<ClassNode>>(
            Hook({ !isBlacklistedClass(it) and !it.isAbstract() and !it.isInner() }, { genContainerFun(it) })
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

    public fun run() {
        genHeader()
        for (classData in extractClasses(jarPath, packageName)) {
            val info: ClassNode = processClassData(classData)
            classHooks.forEach { hook -> hook(info) }
            info.methods!!.forEach { method -> methodHooks.forEach { hook -> hook(MethodNodeWithParent(info, method as MethodNode)) } }
        }
        genContainer()
        genProperties()
        ps.write(settings.getFooter())
        ps.close()
    }

    private fun genHeader() {
        ps.write(settings.getPackage())
        ps.newLine()
        ps.write(settings.getImports())
        ps.newLine()
    }

    private fun genContainer() {
        ps.write(settings.getContainerHeader())
        ps.newLine()
        ps.write(containerCache.toString())
        ps.write("}")
        ps.newLine()
    }

    private fun genProperties() {
        propMap.values().forEach {
            if(!isBlacklistedProperty(it.className + '.' + it.propName)) {
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

    private fun genContainerFun(classInfo: ClassNode) {
        containerCache append "fun "
        containerCache append classInfo.cleanNameDecap()
        containerCache append "( init: " + classInfo.cleanInternalName() + ".() -> Unit): " + classInfo.cleanInternalName() + " {\n"
        containerCache append "val v = " + classInfo.cleanInternalName() + "(ctx)\n"
        containerCache append "v.init()\n"
        containerCache append "vg.addView(v)\n"
        containerCache append "_style(v)\n"
        containerCache append "return v\n}\n\n"
    }

    private fun genContainerClassFun(classinfo: ClassNode) {
        containerClassCache append "class "
        containerClassCache append  classinfo.cleanNameDecap()
        containerClassCache append "("
    }


    private fun processClassData(classData: InputStream?): ClassNode {
        //        val cn = AdslVisitor(Opcodes.V1_6)
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




