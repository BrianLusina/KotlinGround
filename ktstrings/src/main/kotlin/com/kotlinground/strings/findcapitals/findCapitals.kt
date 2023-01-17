package com.kotlinground.strings.findcapitals

fun findCapitals(word: String): IntArray {
    return word.mapIndexed { index, char ->
        if (char.isUpperCase()) {
            index
        } else {
            -1
        }
    }
        .toIntArray()
}
