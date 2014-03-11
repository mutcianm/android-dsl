package ru.ifmo.rain.adsl.xmlconverter

import javax.xml.parsers.SAXParserFactory
import java.io.File
import ru.ifmo.rain.adsl.writeFile

class Converter {
    val buffer = StringBuffer()
    val controlsXmlBuffer = StringBuffer()
    fun run(ifn: String) {
        val spf = SAXParserFactory.newInstance()
        spf?.setNamespaceAware(true)
        val parser = spf?.newSAXParser()
        val reader = parser?.getXMLReader()
        reader?.setContentHandler(XmlHandler(buffer, controlsXmlBuffer, ConverterSettings()))
        reader?.parse(convertToFileURL(ifn))
    }

    public override fun toString(): String {
        return buffer.toString()
    }
}

fun convertToFileURL(filename: String): String {
    var path = File(filename).getAbsolutePath();
    if (File.separatorChar != '/') {
        path = path.replace(File.separatorChar, '/');
    }
    if (!path.startsWith("/")) {
        path = "/" + path;
    }
    return "file:" + path;
}

fun main(args: Array<String>) {
    for (arg in args) {
        val c = Converter()
        c.run(arg)
        writeFile("${arg.replaceAll(".xml", ".kt")}", c.buffer.toString())
        writeFile("${arg.replaceAll(".xml", ".ui.xml")}", c.controlsXmlBuffer.toString())
    }
}