package ru.ifmo.rain.adsl;

fun main(args: Array<String>) {

    val generator = Generator(args[0], args[1], GeneratorSettings())
    try {
        generator.run()
    } catch (e: Exception) {
        System.err.println(e.toString())
        e.printStackTrace()
    }
}
