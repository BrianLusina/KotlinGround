package com.kotlinground.strings.mergstrings

import kotlin.math.max

fun mergeAlternately(word1: String, word2: String): String {
    var mergedString = ""
    val word1Size = word1.length
    val word2Size = word2.length

    var pointerOne = 0
    var pointerTwo = 0

    while (pointerOne < word1Size || pointerTwo < word2Size) {
        if (pointerOne < word1Size) {
            mergedString += word1[pointerOne]
            pointerOne++
        }

        if (pointerTwo < word2Size) {
            mergedString += word2[pointerTwo]
            pointerTwo++
        }
    }

    return mergedString
}

/**
 * Uses 1 pointer to merge 2 strings alternatively
 */
fun mergeAlternately2(word1: String, word2: String): String {
    var mergedString = ""
    val word1Size = word1.length
    val word2Size = word2.length

    val n = max(word1Size, word2Size)

    for (pointer in 0 until n) {
        if (pointer < word1Size) {
            mergedString += word1[pointer]
        }

        if (pointer < word2Size) {
            mergedString += word2[pointer]
        }
    }


    return mergedString
}
