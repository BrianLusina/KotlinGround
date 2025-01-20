package com.kotlinground.strings.isunique

fun isUnique(inputString: String): Boolean {
    val charMap: MutableMap<Char, Boolean> = mutableMapOf()

    for (char in inputString) {
        if (charMap.containsKey(char)) {
            return false
        } else {
            charMap[char] = true
        }
    }

    return true
}
