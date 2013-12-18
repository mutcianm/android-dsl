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

    private fun readLines(fileName: String): MutableList<String> {
        return Files.readAllLines(Paths.get(fileName)!!, StandardCharsets.UTF_8)
    }

    fun getPackage() = "package com.example.adsl"

    fun getContainerBaseClass(): String {
        return "android/view/ViewGroup"
    }

    fun getImports(): String {
        return readFile("imports.txt")
    }

    fun getContainerHeader(): String {
        return readFile("cont_header.txt")
    }

    fun getUIClassHeader(): String {
        return "class _UI(var act: android.app.Activity) {\n"
    }

    fun getFooter(): String {
        return readFile("footer.txt")
    }

    fun getBlackListedClasses(): Set<String> {
        return HashSet<String>(readLines("class_blacklist.txt"))
    }

    fun getBlackListedProperties(): Set<String> {
        return HashSet<String>(readLines("prop_blacklist.txt"))
    }

    fun getContainerClasses(): Set<String> {
        return HashSet<String>(readLines("container_classes.txt"))
    }
}

fun readFile(name: String): String {
    var data = Files.readAllBytes(Paths.get(name) as Path)
    return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(data)).toString()
}

