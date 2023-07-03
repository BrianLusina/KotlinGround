package com.kotlinground.strings.maxvowelsinsubstr

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxVowelsTest {

    @Test
    fun `should return 3 from s = abciiidef and k = 3`() {
        val s = "abciiidef"
        val k = 3
        val expected = 3
        val actual = maxVowels(s, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from s = aeiou and k = 2`() {
        val s = "aeiou"
        val k = 2
        val expected = 2
        val actual = maxVowels(s, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from s = leetcode and k = 3`() {
        val s = "leetcode"
        val k = 3
        val expected = 2
        val actual = maxVowels(s, k)
        assertEquals(expected, actual)
    }
}
