package ru.ifmo.rain.adsl

import java.util.HashSet
import java.util.HashMap
import java.util.ArrayList
import java.io.File

open class GeneratorSettings(override var generateContainerBaseClass: Boolean = true,
                        override var generateProperties: Boolean = true,
                        override var generateSetters: Boolean = true,
                        override var generateGetters: Boolean = true,
                        override var generateContainerClasses: Boolean = true,
                        override var generateUIClass: Boolean = true,
                        override var generateUIClassWrapper: Boolean = true,
                        override var generateImports: Boolean = true,
                        override var generatePackage: Boolean = true,
                        override var generateHelperConstructors: Boolean = true): BaseGeneratorSettings() {

    override fun getOutputFile(subsystem: Subsystems): File {
        return when (subsystem) {
            Subsystems.CONTAINER_BASE_CLASS -> File(dslPath+"Container.kt")
            Subsystems.LAYOUTS -> File(dslPath+"Layouts.kt")
            Subsystems.PROPERTIES -> File(dslPath+"Properties.kt")
            Subsystems.UI_CLASS -> File(dslPath+"UIClasses.kt")
            Subsystems.LISTENER_HELPERS -> File(dslPath+"ListenerHelpers.kt")
            else -> throw RuntimeException("Unable to get output file for non-existing subsystem $subsystem")
        }
    }

    override val dslPath: String = "dsl_out/"

    override val _package: String
        get() = "package com.example.adsl"

    override val containerBaseClass: String
        get() = "android/view/ViewGroup"

    override val widgetBaseClass: String = "android/view/View"

    override val imports: String
        get() = readFile("imports.txt")

    override val containerHeader: String
        get() = readFile("cont_header.txt")

    override val uiClassHeader: String
        get() = "class _UI(var act: android.app.Activity) {\n"

    override val footer: String
        get() = readFile("footer.txt")

    override val blackListedClasses: Set<String>
        get() = HashSet<String>(readLines("class_blacklist.txt"))

    override val blacklistedProperties: Set<String>
        get() = HashSet<String>(readLines("prop_blacklist.txt"))

    override val containerClasses: Set<String>
        get() = HashSet<String>(readLines("container_classes.txt"))

    override val explicitlyProcessedClasses: Set<String>
        get() = HashSet<String>(readLines("explicit_classes.txt"))

    override val helperConstructors: Map<String, List<List<String>>>
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
