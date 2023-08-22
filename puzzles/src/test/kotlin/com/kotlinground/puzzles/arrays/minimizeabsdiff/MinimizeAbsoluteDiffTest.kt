package com.kotlinground.puzzles.arrays.minimizeabsdiff

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeAbsoluteDiffTest {
    @Test
    fun `a = (1, 4, 5, 8, 10), b=(6, 9, 15 ), c = (2, 3, 6, 6) should return 1`() {
        val a = intArrayOf(1, 4, 5, 8, 10)
        val b = intArrayOf(6, 9, 15)
        val c = intArrayOf(2, 3, 6, 6)
        val expected = 1
        val actual = minimizeAbsoluteDifference(a, b, c)

        assertEquals(expected, actual)
    }

    @Test
    fun `a = (5, 8, 10, 15), b=(6, 9, 15, 78, 89), c = (2, 3, 6, 6, 8, 8, 10) should return 1`() {
        val a = intArrayOf(5, 8, 10, 15)
        val b = intArrayOf(6, 9, 15, 78, 89)
        val c = intArrayOf(2, 3, 6, 6, 8, 8, 10)
        val expected = 1
        val actual = minimizeAbsoluteDifference(a, b, c)

        assertEquals(expected, actual)
    }
}