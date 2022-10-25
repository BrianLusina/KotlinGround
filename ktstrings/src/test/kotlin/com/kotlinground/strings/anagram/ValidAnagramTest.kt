package com.kotlinground.strings.anagram

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidAnagramTest {

    @Test
    fun `should return false for 2 strings with different lengths`() {
        val s = "ABCD"
        val t = "ABCDEF"
        val actual = isAnagram(s, t)
        assertFalse(actual)
    }
}
