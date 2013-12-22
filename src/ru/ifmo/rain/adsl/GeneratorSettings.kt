package ru.ifmo.rain.adsl

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer
import java.util.HashSet

class GeneratorSettings(var generateContainerBaseClass: Boolean = true,
                        var generateProperties: Boolean = true,
                        var generateSetters: Boolean = true,
                        var generateGetters: Boolean = true,
                        var generateContainerClasses: Boolean = true,
                        var generateUIClass: Boolean = true,
                        var generateUIClassWrapper: Boolean = true,
                        var generateImports: Boolean = true,
                        var generatePackage: Boolean = true) {

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

}
