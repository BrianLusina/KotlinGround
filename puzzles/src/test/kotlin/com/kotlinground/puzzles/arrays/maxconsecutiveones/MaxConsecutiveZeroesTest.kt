package com.kotlinground.puzzles.arrays.maxconsecutiveones

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxConsecutiveZeroesTest {
    @Test
    fun `should return 6 from nums = 1,1,1,0,0,0,1,1,1,1,0, k = 2`() {
        val nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0)
        val expected = 6
        val k = 2
        val actual = longestOnes(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 10 from nums = 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1, k = 3`() {
        val nums = intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1)
        val expected = 10
        val k = 3
        val actual = longestOnes(nums, k)
        assertEquals(expected, actual)
    }
}
