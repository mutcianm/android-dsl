package ru.ifmo.rain.adsl

import org.objectweb.asm.*

fun Type.toStr(nullable: Boolean = true): String {
    return when (getSort()) {
        Type.BOOLEAN -> "Boolean"
        Type.INT -> "Int"
        Type.FLOAT -> "Float"
        Type.DOUBLE -> "Double"
        Type.LONG -> "Long"
        Type.ARRAY -> {
            val innerType = getElementType()
            if(innerType != null){
                when (getElementType()?.getSort()) {
                    Type.INT -> "IntArray?"
                    Type.FLOAT -> "FloatArray?"
                    Type.DOUBLE -> "DoubleArray?"
                    Type.LONG -> "LongArray?"
                    else -> {
                        "Array<" + typeFilter(innerType.toStr(nullable = false)) + ">?"
                    }
                }
            } else {
                throw RuntimeException("Type is of ArrayType, but element type is null")
            }
        }
        else -> typeFilter(cleanInternalName(getInternalName()!!)) + if(nullable) "?" else ""
    }
}