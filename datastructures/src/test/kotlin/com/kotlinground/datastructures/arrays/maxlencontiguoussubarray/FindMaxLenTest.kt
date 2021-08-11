package com.kotlinground.datastructures.arrays.maxlencontiguoussubarray

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindMaxLenTest {

    @Test
    fun `Should return 2 for binary array of 0, 1`() {
        val nums = intArrayOf(0, 1)
        val expected = 2
        val actual = findMaxLength(nums)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `Should return 2 for binary array of 0, 1, 0`() {
        val nums = intArrayOf(0, 1, 0)
        val expected = 2
        val actual = findMaxLength(nums)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `Should return 6 for binary array of 0, 1, 0, 0, 1, 1, 0`() {
        val nums = intArrayOf(0, 1, 0, 0, 1, 1, 0)
        val expected = 6
        val actual = findMaxLength(nums)
        Assertions.assertEquals(expected, actual)
    }
}
