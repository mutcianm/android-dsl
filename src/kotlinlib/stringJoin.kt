package kotlinlib

public fun buildString(body: (sb: StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    body(sb)
    return sb.toString()
}

public fun Iterator<Any?>.join(separator: String = "", before: String = "", after: String = ""): String {
    return buildString {
        it.append(before)
        while (hasNext()) {
            it.append(next())
            if (hasNext()) {
                it.append(separator)
            }
        }
        it.append(after)
    }
}

public fun Iterable<Any?>.join(separator: String = "", before: String = "", after: String = ""): String
        = iterator().join(separator, before, after)

public fun Array<out Any?>.join(separator: String = "", before: String = "", after: String = ""): String {
    return buildString {
        it.append(before)
        for (i in this.indices) {
            it.append(this[i])
            if (i < size - 1) {
                it.append(separator)
            }
        }
        it.append(after)
    }
}

