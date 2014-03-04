package ru.ifmo.rain.adsl.xmlconverter

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import ru.ifmo.rain.adsl.Context
import java.util.ArrayList
import java.util.HashMap

class XmlHandler(val buffer: StringBuffer, val controlsXmlBuffer: StringBuffer, val settings: BaseConverterSettings): DefaultHandler() {

    val globalCtx = Context(buffer)
    val importsCtx = globalCtx.fork()
    val headerCtx = globalCtx.fork()
    val widgetsDeclCtx = globalCtx.fork(newIndentDepth = globalCtx.indentDepth+1)
    val widgetsBodyCtx = globalCtx.fork(newIndentDepth = globalCtx.indentDepth+1)

    val controlsBuffer = Context(controlsXmlBuffer)
    var lastLayout = ""

    override fun startElement(uri: String?, localName: String?, qName: String, attributes: Attributes?) {
        val layoutParams = ArrayList<String>()
        val attrs = attributes?.toMap()
        if (qName.endsWith("Layout"))
            lastLayout = qName
        widgetsBodyCtx.incIndent()
        val id = produceId(attrs, qName)
        if (id != null) {
            widgetsBodyCtx.writeNoIndent(buildCons(qName, attrs) + " {\n")
            widgetsBodyCtx.incIndent()
            widgetsBodyCtx.writeln("setId(R.id.$id)")
            widgetsBodyCtx.decIndent()
        }
        else
            widgetsBodyCtx.writeln(buildCons(qName, attrs) + " {")
        if (attributes != null) {
            widgetsBodyCtx.incIndent()
            for (attr in attrs) {
                if (isSkippableAttr(attr.key)) continue
                processAttribute(attr.key, attr.value, {name, value ->
                    layoutParams.add("${value?.toUpperCase()}")
                })
            }
            if (!layoutParams.isEmpty()) {
                widgetsBodyCtx.write("layoutParams(")
                for (arg in layoutParams) {
                    widgetsBodyCtx.writeNoIndent(arg + ", ")
                }
                widgetsBodyCtx.trim(2)
                widgetsBodyCtx.writeNoIndent(")\n")
            }
            widgetsBodyCtx.decIndent()
        }
    }

    private fun produceId(attributes: HashMap<String, String>?, widgetClass: String): String? {
        if (attributes == null) return null
        val id = attributes["id"]
        attributes.remove("id")
        if (id == null) return null
        val idValue = id.substring(id.indexOf("/")+1)
        controlsBuffer writeln "<item name=\"$idValue\" type=\"id\"/>"
        widgetsBodyCtx write "$idValue = "
        widgetsDeclCtx writeln "val $idValue: $widgetClass by Delegates.notNull()"
        return idValue
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
        widgetsBodyCtx.writeln("}")
        widgetsBodyCtx.decIndent()
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {

    }

    override fun startDocument() {
        importsCtx writeln "import android.view.ViewGroup.LayoutParams.*"
        importsCtx writeln "import android.widget.*"
        importsCtx writeln "import com.example.adsl.*"
        importsCtx writeln "import kotlin.properties.Delegates"
        headerCtx writeln "\nclass Foo(val act: android.app.Activity) {"
        widgetsDeclCtx.newLine()
        widgetsBodyCtx writeln "{"
        widgetsBodyCtx.incIndent()
        widgetsBodyCtx writeln "UI(act) {"
        controlsBuffer writeln "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
        controlsBuffer writeln "<resources>"
        controlsBuffer.incIndent()
    }

    override fun endDocument() {
        widgetsBodyCtx.writeln("}")
        widgetsBodyCtx.decIndent()
        widgetsBodyCtx.writeln("}")
        controlsBuffer.decIndent()
        controlsBuffer writeln "</resources>"
        widgetsDeclCtx.newLine()
        widgetsBodyCtx.decIndent()
        widgetsBodyCtx.writeln("}")
        globalCtx.absorbChildren()
    }

    private fun processAttribute(name: String?, value: String?, layoutFunc: (String?, String?) -> Unit) {
        when (name) {
            "layout_width" -> layoutFunc(name, value)
            "layout_height" -> layoutFunc(name, value)
            "text" -> widgetsBodyCtx.writeln("$name = \"$value\"")
            "caption" -> widgetsBodyCtx.writeln("$name = \"$value\"")
            else -> widgetsBodyCtx.writeln("$name = $value")
        }
    }
}
