package com.kotlinground.algorithms.backtracking.lettercombination

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LetterCombinationTest {
    @Test
    fun `should return ('a', 'b') for n=1`() {
        val n = 1
        val expected = listOf("a", "b")
        val actual = letterCombination(n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return ('aa', 'ab', 'ba', 'bb') for n=2`() {
        val n = 2
        val expected = listOf("aa", "ab", "ba", "bb")
        val actual = letterCombination(n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return ('aaa','aab', 'aba', 'abb', 'baa', 'bab', 'bba', 'bbb') for n=3`() {
        val n = 3
        val expected = listOf("aaa", "aab", "aba", "abb", "baa", "bab", "bba", "bbb")
        val actual = letterCombination(n)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return () for n=0`() {
        val n = 0
        val expected = emptyList<String>()
        val actual = letterCombination(n)
        assertEquals(expected, actual)
    }
}
