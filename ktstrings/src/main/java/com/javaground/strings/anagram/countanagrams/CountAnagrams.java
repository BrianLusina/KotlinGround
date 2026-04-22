package com.javaground.strings.anagram.countanagrams;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

    // Define modulo constant for large number calculations
    static final int MOD = 1000000007;

    // Define maximum possible word length
    static final int MAX_LEN = 1000;

    // Arrays to store precomputed factorials and their modular inverses
    static long[] factorials = new long[MAX_LEN + 1];
    static long[] invFactorials = new long[MAX_LEN + 1];

    // Fast exponentiation (modular inverse)
    public static long modPow(long base, int exp, int mod) {
        long result = 1;
        long b = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * b) % mod;
            b = (b * b) % mod;
            exp /= 2;
        }
        return result;
    }

    // Precomputes factorials and their modular inverses using Fermat's theorem
    // This allows efficient computation of permutations involving repeated characters
    public static void preCompute() {

        // Compute factorials modulo MOD
        factorials[0] = 1;
        for (int i = 1; i <= MAX_LEN; i++) {
            factorials[i] = (factorials[i - 1] * i) % MOD;
        }

        // Compute modular inverse of MAX_LEN! using Fermat's Little Theorem
        invFactorials[MAX_LEN] = modPow(factorials[MAX_LEN], MOD - 2, MOD);

        // Compute modular inverses for all numbers from MAX_LEN-1 down to 1
        for (int i = MAX_LEN - 1; i > 0; i--) {
            invFactorials[i] = (invFactorials[i + 1] * (i + 1)) % MOD;
        }
    }

    // Computes the number of distinct permutations of a given word, considering repeated characters
    public static long countPermutations(String word) {

        // Count occurrences of each character
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char ch : word.toCharArray()) {
            letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
        }

        // Compute n! for total characters
        long totalPermutations = factorials[word.length()];

        // Divide by factorial of each character count to account for duplicates
        for (int freq : letterCount.values()) {
            totalPermutations = (totalPermutations * invFactorials[freq]) % MOD;
        }

        return totalPermutations;
    }

    // Computes the total number of anagram groups possible for each word in the string
    // The result is the product of permutations for each word, modulo MOD
    public static int of(String s) {

        // Call preCompute once at the beginning to populate factorial tables
        preCompute();

        // Split the sentence into words
        String[] words = s.split(" ");
        long result = 1;

        // Multiply the permutations of each word to get the final count
        for (String word : words) {
            result = (result * countPermutations(word)) % MOD;
        }

        // Cast long to int before returning
        return (int) result;
    }
}
