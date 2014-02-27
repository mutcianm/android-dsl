package ru.ifmo.rain.adsl.xmlconverter

import java.util.Properties;
import java.io.File
import java.io.FileInputStream
import java.util.HashMap
import java.util.ArrayList
import ru.ifmo.rain.adsl.readLines
import java.util.HashSet

open class ConverterSettings: BaseConverterSettings() {

    private val cfgFile = File("converter.properties")
    private val props = Properties();

    {
        try {
            props.load(FileInputStream(cfgFile))
        } catch (e: Exception) {
            println(e.getMessage())
        }
    }

    override val ignoredProperties: Set<String> = readIgnoredProps()
    override val helperConProps: HashMap<String, ArrayList<HashSet<String>>> = readHelperConProps()
    override val quotedKeys: Set<String> = props.getProperty("quoted_keys", "")!!.split(",").toSet()

    private fun readIgnoredProps(): Set<String> {
        return props.getProperty("ignored_props", "")!!.split(",").toSet()
    }

    private fun readHelperConProps(): HashMap<String, ArrayList<HashSet<String>>> {
        val res = HashMap<String, ArrayList<HashSet<String>>>()
        for (line in readLines("helper_constructors.txt")) {
            try {
                with (line.replaceAll("\\s", "").split(':')) {
                    val className = get(0)
                    val constructors = res.getOrElse(className, { ArrayList<HashSet<String>>() })
                    val props = HashSet<String>()
                    for (prop in get(1).split(',')) {
                        props.add(prop)
                    }
                    constructors.add(props)
                    res.put(className, constructors)
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                throw RuntimeException("Failed to tokenize string, malformed helper_constructors.txt")
            }
        }
        return res
    }
}

