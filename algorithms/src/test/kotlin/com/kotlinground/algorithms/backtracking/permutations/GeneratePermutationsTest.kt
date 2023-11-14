package com.kotlinground.algorithms.backtracking.permutations

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GeneratePermutationsTest {
    @Test
    fun `ab should return (ab, ba)`() {
        val input = "ab"
        val expected = listOf("ab", "ba")
        assert(input, expected)
    }

    @Test
    fun `abc should return (abc,acb,bac,bca,cab,cba)`() {
        val input = "abc"
        val expected = listOf("abc", "acb", "bac", "bca", "cab", "cba")
        assert(input, expected)
    }

    private fun assert(input: String, expected: List<String>) {
        val actual = generatePermutations(input)
        assertEquals(expected, actual)
    }
}