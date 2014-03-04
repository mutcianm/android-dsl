package ru.ifmo.rain.adsl

import org.objectweb.asm.*
import org.objectweb.asm.tree.MethodNode
import java.util.ArrayList
import org.objectweb.asm.tree.LocalVariableNode
import java.util.HashMap

val MethodNode.arguments: Array<Type>?
    get() = Type.getArgumentTypes(desc)

fun genericTypeToStr(param: GenericType): String {
//    return ""
    var res = StringBuilder()
    res append when(param.classifier) {
        is ToplevelClass -> cleanInternalName((param.classifier as ToplevelClass).internalName)
        is BaseType -> Type.getType("${(param.classifier as BaseType).descriptor}")!!.toStr()
        else -> throw DSLGeneratorException("Unexpected classifier of generic type: ${param.classifier}")
    }
    if (param.arguments.size > 0) {
        res append "<"
        for (arg in param.arguments) {
            res append when(arg) {
                is UnBoundedWildcard -> "*"
                is NoWildcard -> genericTypeToStr(arg.genericType)
                is BoundedWildcard ->
                        return when(arg.wildcard) {
                            Wildcard.EXTENDS -> "out ${genericTypeToStr(arg.bound)}"
                            Wildcard.SUPER -> "in ${genericTypeToStr(arg.bound)}"
                        }
                else -> throw DSLGeneratorException("Unexpected generic argument type: $arg")
            }
            res append ", "
        }
        res.delete(res.size-2, res.size)
        res append ">"
    }
    if (param.classifier is ToplevelClass) res append "?"
    return res.toString()
}

fun MethodNode.buildKotlinSignature(): List<String> {
    if (signature == null)
        return ArrayList<String>()
    val parsed = parseGenericMethodSignature(signature!!)
    return parsed.valueParameters.map { genericTypeToStr(it.genericType) }
}

fun MethodNode.processArguments(skipType: String = "",  app: (argName: String, argType: String, nullable: String) -> String): String {
    if (getArgumentCount() == 0)
        return ""
    val locals = if (localVariables == null || localVariables!!.isEmpty())
        HashMap<Int, LocalVariableNode>()
    else
        localVariables!!.toMap { a -> a.index to a }
    val buf = StringBuffer()
    var argNum = 0
    var nameIndex = if (isStatic()) 0 else 1
    val genericArgs = buildKotlinSignature()
    for (arg in arguments!!) {
        val argType = arg.toStr()
        val nullable = if (argType.endsWith("?")) "!!" else ""
        val local = locals[nameIndex]
        val argName = local?.name ?: "p$argNum"
        if (skipType != argType)
            buf append app(argName, if(signature != null) genericArgs[argNum] else argType, nullable)
        argNum++
        nameIndex += arg.getSize()
    }
    if ( buf.length >= 2) buf.delete(buf.length-2, buf.length)
    return buf.toString()
}

fun MethodNode.fmtArguments(skipType: String = ""): String {
    return processArguments(skipType) { name, _type, nul -> "$name: $_type, " }
}

fun MethodNode.fmtArgumentsInvoke(skipType: String = ""): String {
    return processArguments(skipType) { name, _type, nul -> "$name$nul, " }
}

fun MethodNode.fmtArgumentsTypes(skipType: String = ""): String {
    return processArguments(skipType) { name, _type, nul -> "$_type, " }
}

fun MethodNode.fmtArgumentsNames(skipType: String = ""): String {
    return processArguments(skipType) { name, _type, nul -> "$name, " }
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

fun MethodNode.renderReturnType(): String {
    return if(signature != null) genericTypeToStr(parseGenericMethodSignature(signature!!).returnType)
    else getReturnType().toStr()
}

fun MethodNode.toProperty(): String {
    val tmp = if (name!!.startsWith("get") || name!!.startsWith("set"))
        name!!.substring(3)
    else
        name!!.substring(2)
    return decapitalize(tmp)
}

