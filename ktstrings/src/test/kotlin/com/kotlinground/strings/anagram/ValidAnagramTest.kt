package com.kotlinground.strings.anagram

import kotlin.test.Test
import kotlin.test.assertFalse

class ValidAnagramTest {

    @Test
    fun `should return false for 2 strings with different lengths`() {
        val s = "ABCD"
        val t = "ABCDEF"
        val actual = isAnagram(s, t)
        assertFalse(actual)
    }
}
