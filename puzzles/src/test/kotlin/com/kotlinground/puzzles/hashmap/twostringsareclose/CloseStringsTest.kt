package com.kotlinground.puzzles.hashmap.twostringsareclose

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CloseStringsTest {
    @Test
    fun `should return true for word1=abc and word2=bca`() {
        val word1 = "abc"
        val word2 = "bca"
        val actual = closeStrings(word1, word2)
        assertTrue(actual)
    }

    @Test
    fun `should return false for word1=a and word2=aa`() {
        val word1 = "a"
        val word2 = "aa"
        val actual = closeStrings(word1, word2)
        assertFalse(actual)
    }

    @Test
    fun `should return true for word1=cabbba and word2=abbccc`() {
        val word1 = "cabbba"
        val word2 = "abbccc"
        val actual = closeStrings(word1, word2)
        assertTrue(actual)
    }
}
