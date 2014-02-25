package ru.ifmo.rain.adsl.xmlconverter

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