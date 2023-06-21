package com.kotlinground.strings.issubsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsSubsequenceTest {
    @Test
    fun `should return true for s=abc & t=ahbgdc`() {
        val s = "abc"
        val t = "ahbgdc"
        val actual = isSubsequence(s = s, t = t)
        assertTrue(actual)
    }

    @Test
    fun `should return false for s=axc & t=ahbgdc`() {
        val s = "axc"
        val t = "ahbgdc"
        val actual = isSubsequence(s = s, t = t)
        assertFalse(actual)
    }

    @Test
    fun `should return true for s='' & t=ahbgdc`() {
        val s = ""
        val t = "ahbgdc"
        val actual = isSubsequence(s = s, t = t)
        assertTrue(actual)
    }

    @Test
    fun `should return true for s='b' & t=abc`() {
        val s = "b"
        val t = "abc"
        val actual = isSubsequence(s = s, t = t)
        assertTrue(actual)
    }
}
