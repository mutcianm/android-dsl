package ru.ifmo.rain.adsl.xmlconverter

import ru.ifmo.rain.adsl.Context
import java.util.ArrayList

open class WidgetContext(): Context() {
    val layoutParams = ArrayList<String>()

    private fun layoutFunc(key: String, value: String) {
        layoutParams.add(value.toUpperCase())
    }

    public fun addProperty(key: String, value: String) {
        when (key) {
            "layout_width" -> layoutFunc(key, value)
            "layout_height" -> layoutFunc(key, value)
            "text" -> writeln("$key = \"$value\"")
            "caption" -> writeln("$key = \"$value\"")
            else -> writeln("$key = $value")
        }
    }

    public override fun toString(): String {
         if (!layoutParams.isEmpty())
            writeln("layoutParams(${layoutParams.makeString()})")
        return buffer.toString()
    }
}

class LayoutContext(): WidgetContext() {
    public override fun write(what: String) {
        writeNoIndent(currentIndent)
        writeNoIndent("viewGroup")
        writeNoIndent(what)
    }
}