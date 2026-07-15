package com.kotlinground.strings.isunique

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsUniqueTest {

    @Test
    fun `should return true for abCDefGh`() {
        val inputString = "abCDefGh"
        val actual = isUnique(inputString)
        assertTrue(actual)
    }

    @Test
    fun `should return false for nonunique`() {
        val inputString = "nonunique"
        val actual = isUnique(inputString)
        assertFalse(actual)
    }

    @Test
    fun `should return true for abCedFghI`() {
        val inputString = "abCedFghI"
        val actual = isUnique(inputString)
        assertTrue(actual)
    }

    @Test
    fun `should return false for I Am Not Unique`() {
        val inputString = "I Am Not Unique"
        val actual = isUnique(inputString)
        assertFalse(actual)
    }

    @Test
    fun `should return False for heythere`() {
        val inputString = "heythere"
        val actual = isUnique(inputString)
        assertFalse(actual)
    }

    @Test
    fun `should return True for hi`() {
        val inputString = "hi"
        val actual = isUnique(inputString)
        assertTrue(actual)
    }
}
