package ru.ifmo.rain.adsl

import org.objectweb.asm.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode
import java.util.ArrayList
import org.objectweb.asm.tree.LocalVariableNode
import java.util.HashMap

public fun decapitalize(name: String): String {
    return name.substring(0, 1).toLowerCase() + name.substring(1)
}

public fun capitalize(name: String): String {
    return name.substring(0, 1).toUpperCase() + name.substring(1)
}

fun stripClassName(name: String): String {
    return name.substring(name.lastIndexOf('.') + 1)
}

fun cleanInternalName(name: String): String {
    return name.replace('/', '.').replace('$', '.')
}

val MethodNode.arguments: Array<Type>?
    get() = Type.getArgumentTypes(desc)

fun MethodNode.processArguments(app: (argName: String, argType: String, nullable: String) -> String): String {
    if (getArgumentCount() == 0)
        return ""
    val locals = if (localVariables == null || localVariables!!.isEmpty())
        HashMap<Int, LocalVariableNode>()
    else
        localVariables!!.toMap { a -> a.index to a }
    val buf = StringBuffer()
    var argNum = 0
    var nameIndex = if (isStatic()) 0 else 1
    for (arg in arguments!!) {
        val argType = arg.toStr()
        val nullable = if (argType.endsWith("?")) "!!" else ""
        val local = locals[nameIndex]
        val argName = local?.name ?: "p$argNum"
        buf append app(argName, argType, nullable)
        argNum++
        nameIndex += arg.getSize()
    }
    buf.delete(buf.length-2, buf.length)
    return buf.toString()
}

fun MethodNode.fmtArguments(): String {
    return processArguments { name, _type, nul -> "$name: $_type, " }
}

fun MethodNode.fmtArgumentsInvoke(): String {
    return processArguments { name, _type, nul -> "$name$nul, " }
}

fun MethodNode.fmtArgumentsTypes(): String {
    return processArguments { name, _type, nul -> "$_type, " }
}

fun MethodNode.isStatic(): Boolean {
    return (access and Opcodes.ACC_STATIC) != 0
}

fun MethodNode.isGetter(): Boolean {
    return (((name!!.startsWith("get") && name!!.length > 3) ||
            (name!!.startsWith("is") && name!!.length > 2)) &&
             arguments?.size == 0 && (getReturnType().getSort() != Type.VOID))
}

fun MethodNode.isSetter(): Boolean {
    return ((name!!.startsWith("set") && name!!.length > 3) && arguments?.size == 1)
}

fun MethodNode.isProperty(): Boolean {
    return ((name!!.startsWith("set") && name!!.length > 3) ||
            (name!!.startsWith("get") && name!!.length > 3) ||
            (name!!.startsWith("is") && name!!.length > 2))
}

fun MethodNode.isProperty(prop: String): Boolean {
    if (!isProperty()) return false
    return (name == "set" + capitalize(prop) ||
    name == "get" + capitalize(prop) ||
    name == "is" + capitalize(prop))
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

public fun ClassNode.getConstructors(): List<MethodNode> {
    return (methods as List<MethodNode>).filter { it.isConstructor() }
}