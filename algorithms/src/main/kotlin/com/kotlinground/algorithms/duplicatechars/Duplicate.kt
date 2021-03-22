package com.kotlinground.algorithms.duplicatechars

object Duplicate {
    fun sortString(word: String): String {
        return word.toCharArray().sorted().joinToString("")
    }

    fun containsDuplicates(wordOne: String, wordTwo: String): Boolean {
        if (wordOne.length != wordTwo.length) {
            return false
        }
        return sortString(wordOne) == sortString(wordTwo)
    }
}