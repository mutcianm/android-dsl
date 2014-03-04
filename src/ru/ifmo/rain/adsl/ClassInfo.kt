package ru.ifmo.rain.adsl

import org.objectweb.asm.*
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodNode

class NoSignatureException(message: String): DSLException(message)

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

class MethodNodeWithParent(var parent: ClassNode, val child: MethodNode)

fun ClassNode.cleanName(): String {
    return stripClassName(cleanInternalName(name!!))
}

fun ClassNode.cleanNameDecap(): String {
    return decapitalize(cleanName())
}

fun ClassNode.buldTypeParams(): String {
    return if (signature != null) {
        val wtf = parseGenericMethodSignature(signature!!)
        if (wtf.typeParameters.isEmpty()) return ""
        val t: List<String> = wtf.typeParameters.map { it.upperBounds.fold("") {i, bound -> i + "out "+ genericTypeToStr(bound)}}
        val res = t.makeString()
        "<$res>"
    } else ""
}

fun ClassNode.cleanInternalName(): String {

    return name!!.replace('/', '.').replace('$', '.') + buldTypeParams()
}

fun ClassNode.toContainerName() = "_${cleanName()}"

fun ClassNode.toContainerInternalName() = "_${cleanInternalName()}"

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