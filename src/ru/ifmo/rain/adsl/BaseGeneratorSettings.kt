package ru.ifmo.rain.adsl

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer
import java.io.File

abstract class BaseGeneratorSettings(open var generateContainerBaseClass: Boolean = true,
                                     open var generateProperties: Boolean = true,
                                     open var generateSetters: Boolean = true,
                                     open var generateGetters: Boolean = true,
                                     open var generateContainerClasses: Boolean = true,
                                     open var generateUIClass: Boolean = true,
                                     open var generateUIClassWrapper: Boolean = true,
                                     open var generateImports: Boolean = true,
                                     open var generatePackage: Boolean = true,
                                     open var generateHelperConstructors: Boolean = true,
                                     open var generateListenerHelpers: Boolean = true) {


    protected fun readFile(name: String): String {
        var data = Files.readAllBytes(Paths.get(name) as Path)
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(data)).toString()
    }

    protected fun readLines(fileName: String): MutableList<String> {
        return Files.readAllLines(Paths.get(fileName)!!, StandardCharsets.UTF_8)
    }

    abstract public fun getOutputFile(subsystem: Subsystems): File

    abstract val dslPath: String

    abstract val _package: String

    abstract val containerBaseClass: String

    abstract val widgetBaseClass: String

    abstract val imports: String

    abstract val containerHeader: String

    abstract val uiClassHeader: String

    abstract val footer: String

    abstract val blackListedClasses: Set<String>

    abstract val blacklistedProperties: Set<String>

    abstract val containerClasses: Set<String>

    abstract val explicitlyProcessedClasses: Set<String>

    abstract val helperConstructors: Map<String, List<List<String>>>
}


