package com.kotlinground.strings.anagram

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsAnagramTest {

    @Test
    fun `should return false for 2 strings with different lengths`() {
        val s = "ABCD"
        val t = "ABCDEF"
        val actual = isAnagram(s, t)
        assertFalse(actual)
    }

    @Test
    fun `should return true for fairy tales and rail safety`() {
        val s = "fairy tales"
        val t = "rail safety"
        val actual = isAnagram(s, t)
        assertTrue(actual)
    }

    @Test
    fun `should return true for William Shakespeare and I am a weakish speller`() {
        val s = "William Shakespeare"
        val t = "I am a weakish speller"
        val actual = isAnagram(s, t)
        assertTrue(actual)
    }

    @Test
    fun `should return true for Madam Curie and Radium came`() {
        val s = "Madam Curie"
        val t = "Radium came"
        val actual = isAnagram(s, t)
        assertTrue(actual)
    }
}
