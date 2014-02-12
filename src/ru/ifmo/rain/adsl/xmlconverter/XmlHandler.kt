package ru.ifmo.rain.adsl.xmlconverter

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import ru.ifmo.rain.adsl.Context
import java.util.ArrayList

class XmlHandler(val buffer: StringBuffer): DefaultHandler() {
    private var depth = 0
//    val buffer = StringBuffer()
    val imports = StringBuffer()
    val ctx = Context(buffer)
    var lastLayout = ""

    override fun startElement(uri: String?, localName: String?, qName: String, attributes: Attributes?) {
        val layoutParams = ArrayList<String>()
        if (qName.endsWith("Layout"))
            lastLayout = qName
        ctx.incIndent()
        ctx.writeln(qName.decapitalize() + " {")
        if (attributes != null) {
            ctx.incIndent()
            for (index in 0..attributes.getLength()-1) {
                val attrName = attributes.getLocalName(index)
                val attrVal = attributes.getValue(index)
                if (isSkippableAttribute(attrName))
                    continue
                processAttribute(attrName, attrVal, {name, value ->
                    layoutParams.add("$lastLayout.${value?.toUpperCase()}")
                })
            }
            if (!layoutParams.isEmpty()) {
                ctx.write("layoutParams(")
                for (arg in layoutParams) {
                    ctx.writeNoIndent(arg + ", ")
                }
                ctx.trim(2)
                ctx.writeNoIndent(") { }\n")
            }
            ctx.decIndent()
        }
    }
    override fun endElement(uri: String?, localName: String?, qName: String) {
        ctx.writeln("}")
        ctx.decIndent()
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {

    }

    override fun startDocument() {
        ctx writeln "public override fun onCreate(savedInstanceState: Bundle?): Unit {"
        ctx.incIndent()
        ctx writeln "super.onCreate(savedInstanceState)"
        ctx writeln "UI {"

    }
    override fun endDocument() {
        ctx.writeln("}")
        ctx.decIndent()
        ctx.writeln("}")
    }

    private fun processAttribute(name: String?, value: String?, layoutFunc: (String?, String?) -> Unit) {
        when (name) {
            "layout_width" -> layoutFunc(name, value)
            "layout_height" -> layoutFunc(name, value)
            "text" -> ctx.writeln("$name = \"$value\"")
            "caption" -> ctx.writeln("$name = \"$value\"")
            else -> ctx.writeln("$name = $value")
        }
    }
}
