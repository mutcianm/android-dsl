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

/**
 * Created with IntelliJ IDEA.
 * User: miha
 * Date: 11/16/13
 * Time: 11:30 PM
 */

fun typeFilter(str: String): String {
    if(str equals "java.lang.CharSequence") return "jet.CharSequence"
    if(str equals "java.lang.String") return "jet.String"
    if(str equals "java.lang.Integer") return "jet.Int"
    if(str equals "java.lang.Object") return "jet.Any"
    return str
}

fun typeStr(_type: Type?): String {
    when (_type?.getSort()) {
        Type.BOOLEAN -> return "Boolean"
        Type.INT -> return "Int"
        Type.FLOAT -> return "Float"
        Type.DOUBLE -> return "Double"
        Type.LONG -> return "Long"
        Type.ARRAY -> {
            when (_type!!.getElementType()!!.getSort()) {
                Type.INT -> return "IntArray?"
                Type.FLOAT -> return "FloatArray?"
                Type.DOUBLE -> return "DoubleArray?"
                Type.LONG -> return "LongArray?"
                null -> return "INVALID"
                else -> {
                    return "Array<" + typeFilter(typeStr(_type!!.getElementType())) + ">?"
                }
            }
        }
        null -> return "Any"
        else -> {
            val tmp = _type.toString()!!.replace('/', '.').replace('$', '.').substring(1)
            if(tmp.isEmpty()) {
                return "WTF"
            }
            return typeFilter(tmp.substring(0, tmp.length - 1)) + '?'
        }
    }
}


fun decapitalize(str: String): String {
    return str.substring(0, 1).toLowerCase() + str.substring(1)
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
}

class Generator(val out: OutputStream, val jarPath: String, val packageName: String) {
    val ps = BufferedWriter(OutputStreamWriter(out))
    val settings = GeneratorSettings()

    val propsCache = StringBuffer(2048)
    val containerCache = StringBuffer(2048)

    class PropData(val classname: String, val propName: String, var propType: Type?, var getter: String?, var setter: String?, var arg: Type?)
    val propMap = TreeMap<String, PropData>()

    public fun run() {
        genHeader()
        extractClasses(jarPath, packageName) map { processClass(it) }
        genContainer()
        genProperties()
        ps.close()
    }


    private fun write(str: String) {
        ps.write(str)
    }

    private fun genHeader() {
        ps.write(settings.getPackage())
        ps.newLine()
        ps.write(settings.getImports())
        ps.newLine()
    }

    private fun genContainer() {
        ps.write(settings.getContainerHeader())
        ps.write("\n")
        ps.write(containerCache.toString())
        ps.write("}\n")
    }

    private fun genProperties() {
        propMap.values().map {
            if(it.getter != null) {
                propsCache append if (it.setter == null) "val " else "var "
                propsCache append it.classname
                propsCache append '.'
                propsCache append decapitalize(it.propName)
                propsCache append ": "
                propsCache append typeStr(it.propType)
                propsCache append '\n'
                propsCache append "\tget() = this."
                propsCache append it.getter
                propsCache append "()\n"
                if(it.setter != null) {
                    propsCache append "\tset(value) = "
                    propsCache append it.setter
                    propsCache append "(value) \n\n"
                } else {
                    propsCache append "\n"
                }
            }
        }

        ps.write(propsCache.toString())
    }

    private fun genSetter(classname: String, propName: String, setter: String, arg: Type) {
        if(!propMap.containsKey(classname + propName)) {
            propMap.put(classname + propName, PropData(classname, propName, null, null, setter, arg))
        } else {
            val prop = propMap.get(classname + propName)
            prop!!.setter = setter
            prop.arg = arg
        }
    }

    private fun genGetter(classname: String, propName: String, getter: String, propType: Type?) {

        if(!propMap.containsKey(classname + propName)) {
            propMap.put(classname + propName, PropData(classname, propName, propType, getter, null, null))
        } else {
            val prop = propMap.get(classname + propName)
            prop!!.getter = getter
            prop.propType = propType
        }
    }

    private fun genContainerFun(classname: String) {
        containerCache append "fun "
        containerCache append decapitalize(classname)
        containerCache append "( init: " + classname + ".() -> Unit): " + classname + " {\n"
        containerCache append "val v = " + classname + "(ctx)\n"
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
        } finally {
            classData?.close()
        }
    }

    private fun extractClasses(jarPath: String, packageName: String): ArrayList<InputStream?> {
        val packageName = packageName.replace('.', '/')
        val jarFile = JarFile(jarPath)
        val wtf: Enumeration<JarEntry> = jarFile.entries() as Enumeration<JarEntry>
        var entries: jet.List<JarEntry> = Collections.list(wtf)
        entries = entries.filter { it.getName().startsWith(packageName) && it.getName().endsWith(".class") }
        var ret = arrayListOf<InputStream?>()
        return entries.mapTo(ret) { jarFile.getInputStream(it) }
    }

    inner class AdslVisitor(api: Int) : ClassVisitor(api) {
        var classname: String = ""
        override fun visit(version: Int, access: Int, name: String?, signature: String?, supername: String?, p5: Array<out String>?) {
            classname = name!!.replace('/', '.').replace('$', '.')
            if(((access and Opcodes.ACC_ABSTRACT) != 0)) {
                return
            }
            if (!name!!.contains("$")) {
                genContainerFun(name.substring(name.lastIndexOf('/') + 1))
            }
        }
        override fun visitMethod(access: Int, name: String?, desc: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
            if((access and Opcodes.ACC_PROTECTED) != 0) return null
            if(classname.contains("Adapter")) return null //HACK
            if(name != null && name.startsWith("set") && Type.getArgumentTypes(desc)?.size == 1) {
                genSetter(classname, name.substring(3), name, Type.getArgumentTypes(desc)!![0])
            } else if (name != null && name.startsWith("get") && Type.getArgumentTypes(desc)?.size == 0) {
                genGetter(classname, name.substring(3), name, Type.getReturnType(desc))
            }
            return null
        }
    }

}




