package com.kotlinground.puzzles.stack.removestars

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RemoveStarsTest {
    @Test
    fun `should return lecoe from leet**cod*e`() {
        val word = "leet**cod*e"
        val expected = "lecoe"
        val actual = removeStars(word)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return '' from erase*****`() {
        val word = "erase*****"
        val expected = ""
        val actual = removeStars(word)
        assertEquals(expected, actual)
    }
}

class RemoveStars2Test {
    @Test
    fun `should return lecoe from leet**cod*e`() {
        val word = "leet**cod*e"
        val expected = "lecoe"
        val actual = removeStars2(word)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return '' from erase*****`() {
        val word = "erase*****"
        val expected = ""
        val actual = removeStars2(word)
        assertEquals(expected, actual)
    }
}