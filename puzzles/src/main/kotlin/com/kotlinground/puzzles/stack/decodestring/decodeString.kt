package com.kotlinground.puzzles.stack.decodestring

import java.lang.StringBuilder
import java.util.Stack

fun decodeString(s: String): String {
    val stack = Stack<String>()
    val countStack = Stack<Int>()
    var countStringBuilder = StringBuilder()
    var result = ""

    for (char in s) {
        when {
            char.isDigit() -> {
                countStringBuilder.append(char)
            }

            char == '[' -> {
                countStack.push(countStringBuilder.toString().toInt())
                stack.push(result)

                countStringBuilder = StringBuilder()
                result = ""
            }

            char == ']' -> {
                val str = stack.pop()
                val count = countStack.pop()
                result = str + result.repeat(count)
            }

            else -> {
                result += char
            }
        }
    }

    return result
}
