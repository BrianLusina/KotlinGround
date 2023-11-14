package com.kotlinground.algorithms.dynamicprogramming.longestcommonsubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceTest {

    @Test
    fun `should return 3 for text1='abcde' and text2='ace'`() {
        val text1 = "abcde"
        val text2 = "ace"
        val expected = 3
        assert(text1, text2, expected)
    }

    @Test
    fun `should return 3 for text1='abc' and text2='abc'`() {
        val text1 = "abc"
        val text2 = "abc"
        val expected = 3
        assert(text1, text2, expected)
    }

    @Test
    fun `should return 0 for text1='abc' and text2='def'`() {
        val text1 = "abc"
        val text2 = "def"
        val expected = 0
        assert(text1, text2, expected)
    }

    private fun assert(text1: String, text2: String, expected: Int) {
        val actual = longestCommonSubsequence(text1, text2)
        assertEquals(expected, actual)
    }
}
