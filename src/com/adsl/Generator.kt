package com.adsl

import java.util.jar.JarEntry
import java.util.Enumeration
import java.util.jar.JarFile
import java.util.Collections
import org.objectweb.asm.*
import java.io.InputStream
import java.util.ArrayList
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.TreeMap
import java.util.HashSet

class IgnoredClassEx : Exception()

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

class GeneratorSettings() {

    fun readFile(name: String): String {
        val data = Files.readAllBytes(Paths.get(name) as Path)
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(data)).toString()
    }

    fun getPackage(): String {
        return "package com.example.andr.dsl"
    }

    fun getImports(): String {
        return readFile("imports.txt")
    }

    fun getContainerHeader(): String {
        return readFile("cont_header.txt")
    }

    fun getBlackListedClasses(): Set<String> {
        val lines = Files.readAllLines(Paths.get("class_blacklist.txt")!!, StandardCharsets.UTF_8)
        return HashSet<String>(lines)
    }

    fun getBlackListedProperties(): Set<String> {
        val lines = Files.readAllLines(Paths.get("prop_blacklist.txt")!!, StandardCharsets.UTF_8)
        return HashSet<String>(lines)
    }
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

    private fun isBlacklistedClass(className: String): Boolean {
        return classBlackList contains className
    }

    private fun isBlacklistedProperty(propertyName: String): Boolean {
        return propBlackList contains propertyName
    }

    public fun run() {
        genHeader()
        extractClasses(jarPath, packageName) forEach { processClass(it) }
        genContainer()
        genProperties()
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

    private fun genSetter(className: String, propName: String, setter: String, arg: Type) {
        val prop = propMap[className + propName]
        if (prop != null) {
            prop.setter = setter
            prop.arg = arg
        } else {
            propMap[className + propName] = PropData(className, propName, null, null, setter, arg)
        }
    }

    private fun genGetter(className: String, propName: String, getter: String, propType: Type?) {
        val prop = propMap[className + propName]
        if (prop != null) {
            if (prop.getter != null)
                return
            prop.getter = getter
            prop.propType = propType
        } else {
            propMap[className + propName] = PropData(className, propName, propType, getter, null, null)
        }
    }

    private fun genContainerFun(className: String) {
        containerCache append "fun "
        containerCache append decapitalize(stripClassName(className))
        containerCache append "( init: " + className + ".() -> Unit): " + className + " {\n"
        containerCache append "val v = " + className + "(ctx)\n"
        containerCache append "v.init()\n"
        containerCache append "vg.addView(v)\n"
        containerCache append "_style(v)\n"
        containerCache append "return v\n}\n\n"
    }


    private fun processClass(classData: InputStream?) {
        val cn = AdslVisitor(Opcodes.ASM5)
        try {
            val cr = ClassReader(classData)
            cr.accept(cn, 0)
        } catch (e: IgnoredClassEx) {
            //optionally log something here
        } finally {
            classData?.close()
        }
    }

    private fun extractClasses(jarPath: String, packageName: String): ArrayList<InputStream?> {
        val packageName = packageName.replace('.', '/')
        val jarFile = JarFile(jarPath)
        var entries: jet.List<JarEntry> = Collections.list(jarFile.entries() as Enumeration<JarEntry>)
        entries = entries.filter { it.getName().startsWith(packageName) && it.getName().endsWith(".class") }
        var ret = arrayListOf<InputStream?>()
        return entries.mapTo(ret) { jarFile.getInputStream(it) }
    }

    inner class AdslVisitor(api: Int) : ClassVisitor(api) {
        var className: String = ""
        override fun visit(version: Int, access: Int, name: String?, signature: String?, supername: String?, p5: Array<out String>?) {
            className = cleanInternalName(name!!)
            if (isBlacklistedClass(className))
                throw IgnoredClassEx()
            if ((access and Opcodes.ACC_ABSTRACT) != 0)
                return
            if (!isInnerClass(name))
                genContainerFun(className)
        }
        override fun visitMethod(access: Int, name: String?, desc: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
            if ((access and Opcodes.ACC_PROTECTED) != 0)
                return null
            if (name != null && name.startsWith("set") && Type.getArgumentTypes(desc)?.size == 1) {
                genSetter(className, name.substring(3), name, Type.getArgumentTypes(desc)!![0])
            } else if (name != null && name.startsWith("get") && Type.getArgumentTypes(desc)?.size == 0) {
                genGetter(className, name.substring(3), name, Type.getReturnType(desc))
            }
            return null
        }
    }

}




