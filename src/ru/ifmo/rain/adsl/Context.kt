package ru.ifmo.rain.adsl

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

    public fun writeNoIndent(what: String) {
        buffer.append(what)
    }

    public fun writeln(what: String) {
        write(what)
        newLine()
    }

    public fun newLine() {
        buffer.append('\n')
    }


    public fun trim(num: Int) {
        buffer.delete(buffer.length-num, buffer.length)
    }
}

