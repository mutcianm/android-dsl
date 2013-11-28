package ru.ifmo.rain.adsl

import org.objectweb.asm.*
import java.util.ArrayList

class MethodInfo(val parent: ClassInfo, val access: Int, val name: String, val desc: String, val signature: String?,
                 val exceptions: Array<out String>?) {

    val arguments = Type.getArgumentTypes(desc)

    public fun isGetter(): Boolean {
        return (name.startsWith("get") && arguments?.size == 0)
    }

    public fun isSetter(): Boolean {
        return (name.startsWith("set") && arguments?.size == 1)
    }

    public fun isConstructor(): Boolean {
        return name == "<init>"
    }

    public fun isProtected(): Boolean {
        return ((access and Opcodes.ACC_PROTECTED) != 0)
    }

    public fun toProperty(): String {
        return decapitalize(name.substring(3))
    }

    public fun getArgumentCount(): Int {
        return if(arguments != null) arguments.size else 0
    }

    public fun getReturnType(): Type? {
        return Type.getReturnType(desc)
    }

    private fun decapitalize(str: String): String {
        return str.substring(0, 1).toLowerCase() + str.substring(1)
    }
}


class ClassInfo(val access: Int, val name: String, val signature: String?, val supername: String?,
                val exceptions: Array<out String>?) {

    var methods: List<MethodInfo> = ArrayList<MethodInfo>()

    public fun cleanName(): String {
        return stripClassName(cleanInternalName(name))
    }

    public fun isInner(): Boolean {
        return isInnerClass(name)
    }

    public fun isInnerClass(): Boolean {
        return name.contains("$")
    }

    public fun isAbstract(): Boolean {
        return ((access and Opcodes.ACC_ABSTRACT) != 0)
    }

    public fun decapitalize(): String {
        return name.substring(0, 1).toLowerCase() + name.substring(1)
    }

    public fun cleanInternalName(): String {
        return name.replace('/', '.').replace('$', '.')
    }

    private fun stripClassName(): String {
        return name.substring(name.lastIndexOf('.') + 1)
    }
}

