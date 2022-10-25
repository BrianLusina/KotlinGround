package com.kotlinground.strings.anagram

/**
 * Checks to see if s is an anagram of t.
 */
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val countS = hashMapOf<String, Int>()
    val countT = hashMapOf<String, Int>()

    s.forEachIndexed { idx, char ->
        countT[t[idx].toString()] = 1 + (countT[t[idx].toString()] ?: 0)

        countS[char.toString()] = 1 + (countS[char.toString()] ?: 0)
        countT[t[idx].toString()] = 1 + (countT[t[idx].toString()] ?: 0)
    }

    return countT == countS
}
