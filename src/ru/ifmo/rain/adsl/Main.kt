package ru.ifmo.rain.adsl;

fun main(args: Array<String>) {

    val generator = Generator(args[0], args[1], GeneratorSettings())
    generator.run()
}
