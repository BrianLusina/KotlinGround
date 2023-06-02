package com.kotlinground.strings.gcdofstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GcdOfStringsBruteForceTest {

    @Test
    fun `should return ABC from str1=ABCABC and str2=ABC`() {
        val str1 = "ABCABC"
        val str2 = "ABC"
        val expected = "ABC"
        val actual = gcdOfStringsBruteForce(str1, str2)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return AB from str1=ABABAB and str2=ABAB`() {
        val str1 = "ABABAB"
        val str2 = "ABAB"
        val expected = "AB"
        val actual = gcdOfStringsBruteForce(str1, str2)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return '' from str1=LEET and str2=CODE`() {
        val str1 = "LEET"
        val str2 = "CODE"
        val expected = ""
        val actual = gcdOfStringsBruteForce(str1, str2)
        assertEquals(expected, actual)
    }
}
