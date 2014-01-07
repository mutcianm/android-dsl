package ru.ifmo.rain.adsl

import org.objectweb.asm.*
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer

class WTFException: Exception()

fun Type.toStr(nullable: Boolean = true): String {
    return when (getSort()) {
        Type.BOOLEAN -> "Boolean"
        Type.INT -> "Int"
        Type.FLOAT -> "Float"
        Type.DOUBLE -> "Double"
        Type.LONG -> "Long"
        Type.BYTE -> "Byte"
        Type.CHAR -> "Char"
        Type.SHORT -> "Short"
        Type.METHOD -> {
            throw WTFException()
        }
        Type.VOID -> "jet.Unit"
        Type.ARRAY -> {
            val innerType = getElementType()
            if (innerType != null) {
                when (getElementType()?.getSort()) {
                    Type.INT -> "IntArray?"
                    Type.FLOAT -> "FloatArray?"
                    Type.DOUBLE -> "DoubleArray?"
                    Type.LONG -> "LongArray?"
                    else -> {
                        "Array<" + typeMap(innerType.toStr(nullable = false)) + ">?"
                    }
                }
            } else {
                throw RuntimeException("Type is of ArrayType, but element type is null")
            }
        }
        else -> {
            try {
                typeMap(cleanInternalName(getInternalName()!!)) + if (nullable) "?" else ""
            } catch (e: NullPointerException) {
                "INVALID"
            }
        }
    }
}

fun readFile(name: String): String {
    var data = Files.readAllBytes(Paths.get(name) as Path)
    return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(data)).toString()
}