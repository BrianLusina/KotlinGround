package com.kotlinground.puzzles.arrays.longestsubarrayofones

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSubArrayTest {
    @Test
    fun `should return 3 from nums = 1,1,0,1`() {
        val nums = intArrayOf(1, 1, 0, 1)
        val expected = 3
        val actual = longestSubArray(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5 from nums = 0,1,1,1,0,1,1,0,1`() {
        val nums = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
        val expected = 5
        val actual = longestSubArray(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from nums = 1,1,1`() {
        val nums = intArrayOf(1, 1, 1)
        val expected = 2
        val actual = longestSubArray(nums)
        assertEquals(expected, actual)
    }
}
