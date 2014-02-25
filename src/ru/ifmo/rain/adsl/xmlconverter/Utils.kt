package ru.ifmo.rain.adsl.xmlconverter

import org.xml.sax.Attributes
import java.util.HashMap

//fun processAttribute(name: String, value: String): String {
//    return when (name) {
//
//        else -> ""
//    }
//}

val ignoredAttrs = "id ems context ignore".split(" ").toSet()

fun isSkippableAttribute(name: String?): Boolean {
    return name in ignoredAttrs
}

public fun Attributes.toMap(): HashMap<String, String> {
    val res = HashMap<String, String>()
    for (index in 0..getLength()-1) {
        val attrName = getLocalName(index)!!
        val attrVal = getValue(index)!!
        res[attrName] = attrVal
    }
    return res
}

public fun StringBuffer.trim(num: Int) {
    delete(length-num, length)
}