package com.kotlinground.puzzles.arrays.trappedrainwater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrappedRainWaterTest {
    @Test
    fun `should return 6 for input of (0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)`() {
        val heights = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val expected = 6
        val actual = trap(heights)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 for input of (1, 2)`() {
        val heights = intArrayOf(1, 2)
        val expected = 0
        val actual = trap(heights)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 9 for input of (4,2,0,3,2,5)`() {
        val heights = intArrayOf(4, 2, 0, 3, 2, 5)
        val expected = 9
        val actual = trap(heights)
        assertEquals(expected, actual)
    }
}