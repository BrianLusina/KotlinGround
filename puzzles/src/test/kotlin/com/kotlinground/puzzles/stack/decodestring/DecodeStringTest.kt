package com.kotlinground.puzzles.stack.decodestring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DecodeStringTest {
    @Test
    fun `should return aaabcbc from 3(a)2(bc)`() {
        val encodedString = "3[a]2[bc]"
        val expected = "aaabcbc"
        val actual = decodeString(encodedString)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return aaabcbc from 3(a2(c))`() {
        val encodedString = "3[a2[c]]"
        val expected = "accaccacc"
        val actual = decodeString(encodedString)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return abcabccdcdcdef from 2(abc)3(cd)ef`() {
        val encodedString = "2[abc]3[cd]ef"
        val expected = "abcabccdcdcdef"
        val actual = decodeString(encodedString)
        assertEquals(expected, actual)
    }
}
