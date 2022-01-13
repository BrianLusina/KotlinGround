package com.kotlinground.datastructures.arrays.twosum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class TwoSumTest {
    @Test
    fun `Should return (0,1) for nums (2,7,11,15) and target = 9`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)
        val actual = twoSum(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `Should return (1,2) for nums (3,2,4) and target = 6`() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)
        val actual = twoSum(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `Should return (0,1) for nums (3,3) and target = 6`() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)
        val actual = twoSum(nums, target)
        assertArrayEquals(expected, actual)
    }
}
