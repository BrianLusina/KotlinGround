package com.kotlinground.strings.palindromes

/**
 * Checks if a given string is a palindrome permutation
 * @param someString [String]  string to check for palindrome property
 * @return [Boolean] True if a palindrome, false otherwise
 */
fun isPalindromePermutation(someString: String): Boolean {
    val normalizedString = someString.replace(" ", "").lowercase()
    val charCount = mutableMapOf<Char, Int>()

    for (char in normalizedString) {
        if (charCount.containsKey(char)) {
            charCount[char] = charCount[char]!! + 1
        } else {
            charCount[char] = 1
        }
    }

    var oddCount = 0
    for (count in charCount.values) {
        val isEven = count % 2 != 0
        if (isEven && oddCount == 0) {
            oddCount++
        } else if (isEven && oddCount != 0) {
            return false
        }
    }
    return true
}
