package ru.ifmo.rain.adsl

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer
import java.util.HashSet
import java.util.HashMap
import java.util.ArrayList

class GeneratorSettings(var generateContainerBaseClass: Boolean = true,
                        var generateProperties: Boolean = true,
                        var generateSetters: Boolean = true,
                        var generateGetters: Boolean = true,
                        var generateContainerClasses: Boolean = true,
                        var generateUIClass: Boolean = true,
                        var generateUIClassWrapper: Boolean = true,
                        var generateImports: Boolean = true,
                        var generatePackage: Boolean = true,
                        var generateHelperConstructors: Boolean = true) {

    private fun readFile(name: String): String {
        var data = Files.readAllBytes(Paths.get(name) as Path)
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(data)).toString()
    }

    private fun readLines(fileName: String): MutableList<String> {
        return Files.readAllLines(Paths.get(fileName)!!, StandardCharsets.UTF_8)
    }

    val _package: String
        get() = "package com.example.adsl"

    val containerBaseClass: String
        get() = "android/view/ViewGroup"

    val imports: String
        get() = readFile("imports.txt")

    val containerHeader: String
        get() = readFile("cont_header.txt")

    val uiClassHeader: String
        get() = "class _UI(var act: android.app.Activity) {\n"

    val footer: String
        get() = readFile("footer.txt")

    val blackListedClasses: Set<String>
        get() = HashSet<String>(readLines("class_blacklist.txt"))

    val blacklistedProperties: Set<String>
        get() = HashSet<String>(readLines("prop_blacklist.txt"))

    val containerClasses: Set<String>
        get() = HashSet<String>(readLines("container_classes.txt"))

    val helperConstructors: Map<String, List<List<String>>>
        get() {
            val res = HashMap<String, ArrayList<ArrayList<String>>>()
            for (line in readLines("helper_constructors.txt")) {
                try {
                    with (line.replaceAll("\\s", "").split(':')) {
                        val className = get(0)
                        val constructors = res.getOrElse(className, { ArrayList<ArrayList<String>>() })
                        val props = ArrayList<String>()
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
