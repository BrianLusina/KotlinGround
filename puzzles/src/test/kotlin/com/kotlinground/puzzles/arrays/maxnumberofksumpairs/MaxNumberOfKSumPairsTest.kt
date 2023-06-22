package com.kotlinground.puzzles.arrays.maxnumberofksumpairs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxNumberOfKSumPairsTest {
    @Test
    fun `should return 2 for nums = 1,2,3,4 and k = 5`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val k = 5
        val expected = 2
        val actual = maxOperations(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 for nums = 3,1,3,4,3 and k = 6`() {
        val nums = intArrayOf(3, 1, 3, 4, 3)
        val k = 6
        val expected = 1
        val actual = maxOperations(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 for nums = 4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4 and k = 2`() {
        val nums = intArrayOf(4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4)
        val k = 2
        val expected = 2
        val actual = maxOperations(nums, k)
        assertEquals(expected, actual)
    }
}
