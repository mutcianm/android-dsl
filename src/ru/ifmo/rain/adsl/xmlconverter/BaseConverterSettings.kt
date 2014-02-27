package ru.ifmo.rain.adsl.xmlconverter

import java.util.HashMap
import java.util.ArrayList
import java.util.HashSet

abstract class BaseConverterSettings {
    abstract val ignoredProperties: Set<String>
    abstract val quotedKeys: Set<String>
    abstract val helperConProps: HashMap<String, ArrayList<HashSet<String>>>
}

