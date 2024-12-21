package com.kotlinground.strings.anagram

/**
 * Checks to see if s is an anagram of t.
 */
fun isAnagram(s: String, t: String): Boolean {
    val s1 = s.replace(" ", "").lowercase()
    val s2 = t.replace(" ", "").lowercase()

    if (s1.length != s2.length) {
        return false
    }

    val map = mutableMapOf<Char, Int>()

    for (char in s1) {
        map[char] = map[char]?.plus(1) ?: 1
    }

    for (char in s2) {
        if (map.containsKey(char)) {
            map[char] = map[char]?.minus(1) ?: 1
        } else {
            map[char] = 1
        }
    }

    for ((_, count) in map) {
        if (count != 0) {
            return false
        }
    }

    return true
}
