package com.kotlinground.strings.anagram

/**
 * Checks to see if s is an anagram of t.
 */
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val arr = IntArray(26)
    s.forEach { arr[it - 'a']++ }
    t.forEach { arr[it - 'a']-- }
    return arr.none { it > 0 }
}
