package ru.ifmo.rain.adsl;

import java.io.FileOutputStream

fun main(args: Array<String>) {
    val generator = Generator(FileOutputStream("out.kt"), args[0], args[1])
    generator.run()
}
