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

fun typeFilter(str: String): String {
    return when (str) {
        "java.lang.CharSequence" -> "jet.CharSequence"
        "java.lang.String" -> "jet.String"
        "java.lang.Integer" -> "jet.Int"
        "java.lang.Object" -> "jet.Any"
        else -> str
    }
}

fun cleanInternalName(name: String): String {
    return name.replace('/', '.').replace('$', '.')
}

fun isInnerClass(name: String): Boolean {
    return name.contains("$")
}

fun typeStr(_type: Type?, nullable: Boolean = true): String {
    if (_type != null) {
        return when (_type.getSort()) {
            Type.BOOLEAN -> "Boolean"
            Type.INT -> "Int"
            Type.FLOAT -> "Float"
            Type.DOUBLE -> "Double"
            Type.LONG -> "Long"
            Type.ARRAY -> {
                when (_type.getElementType()?.getSort()) {
                    Type.INT -> "IntArray?"
                    Type.FLOAT -> "FloatArray?"
                    Type.DOUBLE -> "DoubleArray?"
                    Type.LONG -> "LongArray?"
                    else -> {
                        "Array<" + typeFilter(typeStr(_type.getElementType(), nullable = false)) + ">?"
                    }
                }
            }
            else -> {
                return typeFilter(cleanInternalName(_type.getInternalName()!!)) + if(nullable) "?" else ""
            }
        }
    } else
        throw RuntimeException("Type can't be null(this sholdn't happen)")
}


fun decapitalize(str: String): String {
    return str.substring(0, 1).toLowerCase() + str.substring(1)
}

fun stripClassName(className: String): String {
    return className.substring(className.lastIndexOf('.') + 1)
}

class Generator(val out: OutputStream, val jarPath: String, val packageName: String) {
    val ps = BufferedWriter(OutputStreamWriter(out))
    val settings = GeneratorSettings()

    val propsCache = StringBuffer()
    val containerCache = StringBuffer()

    class PropData(val className: String, val propName: String, var propType: Type?, var getter: String?, var setter: String?, var arg: Type?)
    val propMap = TreeMap<String, PropData>()

    val classBlackList = settings.getBlackListedClasses()
    val propBlackList = settings.getBlackListedProperties()

    val classHooks = Arrays.asList<Hook<ClassInfo>>(
            Hook({ !isBlacklistedClass(it.name) and !it.isAbstract() }, { genContainerFun(it) }),
            Hook({ true }, { System.out.println(it.cleanName()) })
    )

    val methodHooks = Arrays.asList<Hook<MethodInfo>>(
            Hook({ it.isGetter() }, { genGetter() })
    )

    private fun isBlacklistedClass(className: String): Boolean {
        return classBlackList contains className
    }

    private fun isBlacklistedProperty(propertyName: String): Boolean {
        return propBlackList contains propertyName
    }

    public fun run() {
        genHeader()
        //        for (it in classHooks)
        extractClasses(jarPath, packageName) forEach {
            val info = processClassData(it)

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
            if(!isBlacklistedProperty(it.className + '.' + decapitalize(it.propName))) {
                if (it.getter != null) {
                    propsCache append if (it.setter == null) "val " else "var "
                    propsCache append it.className
                    propsCache append '.'
                    propsCache append decapitalize(it.propName)
                    propsCache append ": "
                    propsCache append typeStr(it.propType)
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

    private fun genSetter(classInfo: ClassInfo, methodInfo: MethodInfo) {
        //        private fun genSetter(className: String, propName: String, setter: String, arg: Type) {
        val prop = propMap[classInfo.name + methodInfo.toProperty()]
        if (prop != null) {
            prop.setter = methodInfo.name
            prop.arg = methodInfo.arguments!![0]
        } else {
            propMap[classInfo.name + methodInfo.toProperty()] = PropData(classInfo.name, methodInfo.toProperty(),
                    null, null, methodInfo.name, methodInfo.arguments!![0])
        }
    }

    private fun genGetter(classInfo: ClassInfo, methodInfo: MethodInfo) {
        //        private fun genGetter(className: String, propName: String, getter: String, propType: Type?) {
        val prop = propMap[classInfo.name + methodInfo.toProperty()]
        if (prop != null) {
            if (prop.getter != null)
                return
            prop.getter = methodInfo.name
            prop.propType = methodInfo.getReturnType()
        } else {
            propMap[classInfo.name + methodInfo.toProperty()] = PropData(classInfo.name, methodInfo.toProperty(),
                    methodInfo.getReturnType(), methodInfo.name, null, null)
        }
    }

    private fun genContainerFun(classInfo: ClassInfo) {
        containerCache append "fun "
        containerCache append classInfo.decapitalize()
        containerCache append "( init: " + classInfo.cleanInternalName() + ".() -> Unit): " + classInfo.cleanInternalName() + " {\n"
        containerCache append "val v = " + classInfo.cleanInternalName() + "(ctx)\n"
        containerCache append "v.init()\n"
        containerCache append "vg.addView(v)\n"
        containerCache append "_style(v)\n"
        containerCache append "return v\n}\n\n"
    }


    private fun processClassData(classData: InputStream?): ClassInfo? {
        val cn = AdslVisitor(Opcodes.V1_6)
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: IgnoredClassEx) {
            //optionally log something here
        } finally {
            classData?.close()
        }
        return cn.classInfo
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




