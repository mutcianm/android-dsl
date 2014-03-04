package ru.ifmo.rain.adsl.xmlconverter

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import ru.ifmo.rain.adsl.Context
import java.util.ArrayList
import java.util.HashMap

class XmlHandler(val buffer: StringBuffer, val settings: BaseConverterSettings): DefaultHandler() {
    private var depth = 0
//    val buffer = StringBuffer()
    val imports = StringBuffer()
    val ctx = Context(buffer)
    var lastLayout = ""

    override fun startElement(uri: String?, localName: String?, qName: String, attributes: Attributes?) {
        val layoutParams = ArrayList<String>()
        val attrs = attributes?.toMap()
        if (qName.endsWith("Layout"))
            lastLayout = qName
        ctx.incIndent()
        ctx.writeln(buildCons(qName, attrs) + " {")
        if (attributes != null) {
            ctx.incIndent()
            for (attr in attrs) {
                if (isSkippableAttr(attr.key))
                    continue
                processAttribute(attr.key, attr.value, {name, value ->
                    layoutParams.add("$lastLayout.${value?.toUpperCase()}")
                })
            }
            if (!layoutParams.isEmpty()) {
                ctx.write("layoutParams(")
                for (arg in layoutParams) {
                    ctx.writeNoIndent(arg + ", ")
                }
                ctx.trim(2)
                ctx.writeNoIndent(")\n")
            }
            ctx.decIndent()
        }
    }


    private fun isSkippableAttr(name: String?): Boolean {
        return name in settings.ignoredProperties
    }

    private fun quote(key: String, value: String?): String? {
        return if (key in settings.quotedKeys) "\"$value\"" else value
    }

    private fun buildCons(qName: String, attrs: HashMap<String, String>?): String {
        if(attrs == null)
            return qName.decapitalize()
        //FIXME: how to deal with name clashes?
        val classInternalName = settings.helperConProps.keySet().find { it.endsWith(qName) }
        val constructors = settings.helperConProps[classInternalName]
        //no helper constructors at all
        if (constructors == null)
            return qName.decapitalize()
        //else find constructor with as many matching arguments as possible
        val attrKeys = attrs.keySet()
        var bestMatchingCons: Set<String>? = null
        for (cons in constructors) {
            if (cons.all { it in attrKeys })
                if (bestMatchingCons != null) {
                    if (cons.size > bestMatchingCons!!.size)
                        bestMatchingCons = cons
                } else {
                    bestMatchingCons = cons
                }
        }
        //no matching constructor found
        if (bestMatchingCons == null)
            return qName.decapitalize()
        val res = StringBuffer()
        res append "${qName.decapitalize()}("
        for (arg in bestMatchingCons!!) {
            res append "$arg = ${quote(arg,attrs[arg])}, "
            attrs.remove(arg)
        }
        res.trim(2)
        res append ")"
        return res.toString()
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
