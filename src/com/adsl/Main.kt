package com.adsl

/**
 * Created with IntelliJ IDEA.
 * User: miha
 * Date: 11/16/13
 * Time: 5:51 PM
 */

import org.objectweb.asm.*
import org.objectweb.asm.tree.*
import java.util.jar.JarFile
import java.util.jar.JarEntry
import java.util.Enumeration
import java.io.FileOutputStream

fun main(args: Array<String>) {
    val jarPath = args[0]
    val packageName = args[1]
    val generator = Generator(FileOutputStream("out.kt"), args[0], args[1])
    generator.run()
}
