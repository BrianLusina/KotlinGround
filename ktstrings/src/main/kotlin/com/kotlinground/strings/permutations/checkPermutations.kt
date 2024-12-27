package com.kotlinground.strings.permutations

import kotlin.collections.set

/**
 * Check if two strings are permutations of each other. Returns true if thy are false otherwise
 *
 * Complexity:
 * Time: O(nlog(n)) as sorting is used and sorting here is an O(nlog(n)) time complexity
 * Space: O(1) as no extra space is used to achieve checking for permutations
 */
fun checkPermutationWithSorting(inputStr1: String, inputStr2: String): Boolean {
    // strings of different lengths cannot be permutations of each other
    if (inputStr1.length != inputStr2.length) {
        return false
    }

    val inputStr1Sorted = inputStr1.lowercase().split("").sorted()
    val inputStr2Sorted = inputStr2.lowercase().split("").sorted()

    for ((idx, _) in inputStr1Sorted.withIndex()) {
        if (inputStr1Sorted[idx] != inputStr2Sorted[idx]) {
            return false
        }
    }
    return true
}

/**
 * checks that two strings are permutations of each other and returns true if they are or false
 * otherwise.
 * Complexity:
 * Time: O(n) as it iterates through the strings once
 * Space: O(n) as it uses a map to store the frequency of each character in the strings
 *
 * */
fun checkPermutationWithMap(inputStr1: String, inputStr2: String): Boolean {
    // strings of different lengths cannot be permutations of each other
    if (inputStr1.length != inputStr2.length) {
        return false
    }

    val inputStr1Lower = inputStr1.lowercase()
    val inputStr2Lower = inputStr2.lowercase()

    val charCountMap = mutableMapOf<Char, Int>()

    for (char in inputStr1Lower) {
        if (charCountMap.containsKey(char)) {
            charCountMap[char] = charCountMap[char]!! + 1
        } else {
            charCountMap[char] = 1
        }
    }

    for (char in inputStr2Lower) {
        if (charCountMap.containsKey(char)) {
            charCountMap[char] = charCountMap[char]!! - 1
        } else {
            return false
        }
    }

    for (count in charCountMap.values) {
        if (count != 0) {
            return false
        }
    }

    return true
}
