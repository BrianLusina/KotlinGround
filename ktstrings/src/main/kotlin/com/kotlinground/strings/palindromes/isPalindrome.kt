package com.kotlinground.strings.palindromes

/**
 * Checks if a given string is a palindrome
 * @param s [String]  string to check for palindrome property
 * @return [Boolean] True if a palindrome, false otherwise
 */
fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        while (left < right && !s[left].isLetterOrDigit()) {
            left++
        }
        while (left < right && !s[right].isLetterOrDigit()) {
            right--
        }

        if (s[left].lowercase() != s[right].lowercase()) {
            return false
        }

        left++
        right--
    }

    return true
}
