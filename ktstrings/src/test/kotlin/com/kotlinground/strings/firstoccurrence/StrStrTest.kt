package com.kotlinground.strings.firstoccurrence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrStrTest {
    @Test
    fun `haystack = sadbutsad, needle = sad`() {
        val haystack = "sadbutsad"
        val needle = "sad"
        val expected = 0
        val actual = strStr(haystack, needle)
        assertEquals(expected, actual)
    }

    @Test
    fun `haystack=leetcode, needle = leeto`() {
        val haystack = "leetcode"
        val needle = "leeto"
        val expected = -1
        val actual = strStr(haystack, needle)
        assertEquals(expected, actual)
    }

}
