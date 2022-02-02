package com.kotlinground.datastructures.arrays.maxsumsubarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxSubArrayTest {

    @Test
    fun `Should return 6 for nums=(-2,1,-3,4,-1,2,1,-5,4)`() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val result = maxSubArray(nums)
        val expected = 6
        assertEquals(expected, result)
    }

    @Test
    fun `Should return 1 for nums=(1)`() {
        val nums = intArrayOf(1)
        val result = maxSubArray(nums)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `Should return 23 for nums=(5,4,-1,7,8)`() {
        val nums = intArrayOf(5, 4, -1, 7, 8)
        val result = maxSubArray(nums)
        val expected = 23
        assertEquals(expected, result)
    }
}
