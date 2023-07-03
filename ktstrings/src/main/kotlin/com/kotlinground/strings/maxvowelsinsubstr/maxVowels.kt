package com.kotlinground.strings.maxvowelsinsubstr

fun maxVowels(s: String, k: Int): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var currentMaxVowels = 0
    var maxLen = 0

    for (x in s.indices) {
        currentMaxVowels += if (vowels.contains(s[x])) 1 else 0

        if (x >= k) {
            currentMaxVowels -= if (vowels.contains(s[x - k])) 1 else 0
        }
        maxLen = maxOf(currentMaxVowels, maxLen)
    }

    return maxLen
}
