package com.kotlinground.strings.anagram.countanagrams

// Computes the total number of anagram groups possible for each word in the string
// The result is the product of permutations for each word, modulo MOD
/**
 * Calculates the total number of possible distinct anagrams in a given sentence,
 * considering whitespace-separated words and accounting for repeated characters
 * within each word.
 *
 * @param s The input string containing multiple words separated by spaces.
 * @return The total number of distinct anagrams modulo 10^9+7.
 */
fun countAnagrams(s: String): Int {
    // Define modulo constant for large number calculations
    val mod = 1000000007
    // Define maximum possible word length
    val maxLen = 1000000

    // Arrays to store precomputed factorials and their modular inverses
    val factorials = LongArray(maxLen + 1)
    val invFactorials = LongArray(maxLen + 1)

    // Fast exponentiation (modular inverse)
    fun modPow(base: Long, exp: Int, mod: Int): Long {
        var exp = exp
        var result: Long = 1
        var b = base % mod
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * b) % mod
            b = (b * b) % mod
            exp /= 2
        }
        return result
    }

    // Precomputes factorials and their modular inverses using Fermat's theorem
    // This allows efficient computation of permutations involving repeated characters
    fun preCompute() {
        // Compute factorials modulo MOD

        factorials[0] = 1
        for (i in 1..maxLen) {
            factorials[i] = (factorials[i - 1] * i) % mod
        }

        // Compute modular inverse of MAX_LEN! using Fermat's Little Theorem
        invFactorials[maxLen] = modPow(factorials[maxLen], mod - 2, mod)

        // Compute modular inverses for all numbers from MAX_LEN-1 down to 1
        for (i in maxLen - 1 downTo 1) {
            invFactorials[i] = (invFactorials[i + 1] * (i + 1)) % mod
        }
    }

    // Computes the number of distinct permutations of a given word, considering repeated characters
    fun countPermutations(word: String): Long {
        // Count occurrences of each character

        val letterCount: MutableMap<Char?, Int?> = HashMap<Char?, Int?>()
        for (ch in word.toCharArray()) {
            letterCount.put(ch, letterCount.getOrDefault(ch, 0)!! + 1)
        }

        // Compute n! for total characters
        var totalPermutations = factorials[word.length]

        // Divide by factorial of each character count to account for duplicates
        for (freq in letterCount.values) {
            totalPermutations = (totalPermutations * invFactorials[freq!!]) % mod
        }

        return totalPermutations
    }

    // Call preCompute once at the beginning to populate factorial tables

    preCompute()

    // Split the sentence into words
    val words = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    var result: Long = 1

    // Multiply the permutations of each word to get the final count
    for (word in words) {
        result = (result * countPermutations(word)) % mod
    }

    // Cast long to int before returning
    return result.toInt()
}
