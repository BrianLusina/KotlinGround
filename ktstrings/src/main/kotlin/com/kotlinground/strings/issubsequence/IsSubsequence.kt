package com.kotlinground.strings.issubsequence

fun isSubsequence(s: String, t: String): Boolean {
    if (s.length > t.length) {
        return false
    }

    if (s.isEmpty()) {
        return true
    }

    var i = 0
    var j = 0

    while (i < s.length && j < t.length) {
        if (s[i] == t[j]) {
            i++
        }
        j++
    }
    return i == s.length
}
