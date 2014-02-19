package ru.ifmo.rain.adsl

open class InvalidIndent(num: Int) : DSLWriterException("Indentation level < 0: $num")

class Context(val buffer: StringBuffer, var indentDepth: Int = 0) {
    val indentUnit = "    "
    private var currentIndent = indentUnit.repeat(indentDepth)

    public fun inc(): Context {
        indentDepth++
        currentIndent += indentUnit
        return this
    }

    public fun dec(): Context {
        indentDepth--
        if(indentDepth < 0)
            throw InvalidIndent(indentDepth)
        currentIndent = currentIndent.substring(0, currentIndent.length - indentUnit.length)
        return this
    }

    public fun incIndent() {
        inc()
    }

    public fun decIndent() {
        dec()
    }

    public fun write(what: String) {
        buffer.append(currentIndent)
        buffer.append(what)
    }

    public fun writeln(what: String) {
        write(what)
        newLine()
    }

    public fun newLine() {
        buffer.append('\n')
    }
}

