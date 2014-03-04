package ru.ifmo.rain.adsl

import java.util.ArrayList

open class InvalidIndent(num: Int) : DSLWriterException("Indentation level < 0: $num")

class Context(val buffer: StringBuffer = StringBuffer(), var indentDepth: Int = 0) {
    val indentUnit = "    "
    private var currentIndent = indentUnit.repeat(indentDepth)
    val children = ArrayList<Context>()

    public fun incIndent() {
        indentDepth++
        currentIndent += indentUnit
    }

    public fun decIndent() {
        indentDepth--
        if(indentDepth < 0)
            throw InvalidIndent(indentDepth)
        currentIndent = currentIndent.substring(0, currentIndent.length - indentUnit.length)
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

    public fun fork(newBuffer: StringBuffer = StringBuffer(), newIndentDepth: Int = indentDepth): Context {
        val child = Context(newBuffer, newIndentDepth)
        children.add(child)
        return child
    }

    public fun absorbChildren(noIndent: Boolean = true) {
        for (child in children) {
            child.absorbChildren()
            if (noIndent)
                writeNoIndent(child.toString())
            else
                write(child.toString())
        }
    }

    public fun toString(): String {
        return buffer.toString()
    }
}

