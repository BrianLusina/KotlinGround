package com.kotlinground.puzzles.arrays.containerwithmostwater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {
    @Test
    fun `should return 49 from height=1,8,6,2,5,4,8,3,7`() {
        val expected = 49
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val actual = maxArea(height)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from height=1,1`() {
        val expected = 1
        val height = intArrayOf(1, 1)
        val actual = maxArea(height)
        assertEquals(expected, actual)
    }
}
