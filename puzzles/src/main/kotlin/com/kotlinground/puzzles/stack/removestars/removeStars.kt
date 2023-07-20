package com.kotlinground.puzzles.stack.removestars

fun removeStars(s: String): String {
    val stack = arrayListOf<Char>()

    for (char in s) {
        if (char == '*') {
            stack.removeLast()
        } else {
            stack.add(char)
        }
    }

    return stack.joinToString("")
}

fun removeStars2(s: String): String {
    val stack = CharArray(s.length)
    var length = 0
    for (ch in s) {
        if (ch == '*')
            --length
        else
            stack[length++] = ch
    }
    return String(stack, 0, length)
}
