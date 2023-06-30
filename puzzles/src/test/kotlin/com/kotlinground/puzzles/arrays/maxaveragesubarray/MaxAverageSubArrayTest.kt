package com.kotlinground.puzzles.arrays.maxaveragesubarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxAverageSubArrayTest {

    @Test
    fun `should return 12_75000 where nums = 1 12,-5,-6,50,3 and k = 4`() {
        val nums = intArrayOf(1, 12, -5, -6, 50, 3)
        val k = 4
        val expected = 12.75000
        val actual = findMaxAverage(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5_00000 where nums = 5 and k = 1`() {
        val nums = intArrayOf(5)
        val k = 1
        val expected = 5.00000
        val actual = findMaxAverage(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2_00000 where nums = 0,1,1,3,3, and k = 4`() {
        val nums = intArrayOf(0, 1, 1, 3, 3)
        val k = 4
        val expected = 2.00000
        val actual = findMaxAverage(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2_80000 where nums = 4, 0, 4, 3, 3, and k = 5`() {
        val nums = intArrayOf(4, 0, 4, 3, 3)
        val k = 5
        val expected = 2.80000
        val actual = findMaxAverage(nums, k)
        assertEquals(expected, actual)
    }
}
