package ru.ifmo.rain.adsl

import org.objectweb.asm.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

public fun decapitalize(name: String): String {
    return name.substring(0, 1).toLowerCase() + name.substring(1)
}

fun stripClassName(name: String): String {
    return name.substring(name.lastIndexOf('.') + 1)
}

fun cleanInternalName(name: String): String {
    return name.replace('/', '.').replace('$', '.')
}

val MethodNode.arguments: Array<Type>?
    get() = Type.getArgumentTypes(desc)

fun MethodNode.isGetter(): Boolean {
    return ((name!!.startsWith("get") || name!!.startsWith("is")) && arguments?.size == 0)
}

fun MethodNode.isSetter(): Boolean {
    return (name!!.startsWith("set") && arguments?.size == 1)
}

fun MethodNode.isConstructor(): Boolean {
    return name == "<init>"
}

fun MethodNode.isProtected(): Boolean {
    return ((access and Opcodes.ACC_PROTECTED) != 0)
}

fun MethodNode.isGeneric(): Boolean {
    return signature != null
}

fun MethodNode.getArgumentCount(): Int {
    //wtf !!
    return if (arguments != null) arguments!!.size else 0
}

fun MethodNode.getReturnType(): Type {
    return Type.getReturnType(desc)!!
}

fun MethodNode.toProperty(): String {
    val tmp = if (name!!.startsWith("get") || name!!.startsWith("set"))
        name!!.substring(3)
    else
        name!!.substring(2)
    return decapitalize(tmp)
}

class MethodNodeWithParent(var parent: ClassNode, val child: MethodNode)

//fun MethodNode.getClassName(): String {
//
//}

fun ClassNode.cleanName(): String {
    return stripClassName(cleanInternalName(name!!))
}

fun ClassNode.cleanNameDecap(): String {
    return decapitalize(cleanName())
}

fun ClassNode.cleanInternalName(): String {
    return name!!.replace('/', '.').replace('$', '.')
}
fun ClassNode.isInner(): Boolean {
    return name!!.contains("$")
}

public fun ClassNode.isAbstract(): Boolean {
    return ((access and Opcodes.ACC_ABSTRACT) != 0)
}

public fun ClassNode.isGeneric(): Boolean {
    return signature != null
}