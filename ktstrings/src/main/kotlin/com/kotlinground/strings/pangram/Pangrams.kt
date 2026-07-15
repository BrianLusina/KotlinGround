package com.kotlinground.strings.pangram

/**
 * @author lusinabrian on 08/06/17.
 */
object Pangrams {

    fun isPangram(sentence: String): Boolean {
        if (sentence.isNullOrEmpty())
            return false
        var i = 0
        sentence.toCharArray()
                .map { it.uppercaseChar().toInt() }
                .filter { it.toChar() in 'A'..'Z' }
                .forEach { i = i or (1 shl it.toChar() - 'A') }

        return i == i or (1 shl ('Z') + 1 - 'A') - 1
    }

    val alphaLength = 26
    fun isPangramX(input: String) = input.lowercase().replace(Regex("[^a-z]"), "").toSet().size == alphaLength

}

