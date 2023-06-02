package com.kotlinground.strings.gcdofstrings

import kotlin.math.min

fun gcdOfStringsBruteForce(str1: String, str2: String): String {
    val len1 = str1.length
    val len2 = str2.length

    val n = min(len1, len2)

    val valid = fun(k: Int): Boolean {
        if (len1 % k > 0 || len2 % k > 0) {
            return false
        }

        val base = str1.substring(0, k)

        return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty()
    }

    for (i in n downTo 1) {
        if (valid(i)) {
            return str1.substring(0, i)
        }
    }

    return ""
}
