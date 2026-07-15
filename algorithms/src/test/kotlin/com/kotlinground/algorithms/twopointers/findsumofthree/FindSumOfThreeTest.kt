package com.kotlinground.algorithms.twopointers.findsumofthree

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FindSumOfThreeTest {
    @Test
    fun `should return False for nums=(1,-1,0), target=-1`() {
        val nums = intArrayOf(1, -1, 0)
        val target = -1
        val actual = findSumOfThree(nums, target)
        assertFalse(actual)
    }

    @Test
    fun `should return True for nums=(3,7,1,2,8,4,5), target=10`() {
        val nums = intArrayOf(3,7,1,2,8,4,5)
        val target = 10
        val actual = findSumOfThree(nums, target)
        assertTrue(actual)
    }

    @Test
    fun `should return false for nums=(3,7,1,2,8,4,5), target=21`() {
        val nums = intArrayOf(3,7,1,2,8,4,5)
        val target = 21
        val actual = findSumOfThree(nums, target)
        assertFalse(actual)
    }

    @Test
    fun `should return True for nums=(-1,2,1,-4,5,-3), target=-8`() {
        val nums = intArrayOf(-1,2,1,-4,5,-3)
        val target = -8
        val actual = findSumOfThree(nums, target)
        assertTrue(actual)
    }

    @Test
    fun `should return True for nums=(-1,2,1,-4,5,-3), target=0`() {
        val nums = intArrayOf(-1,2,1,-4,5,-3)
        val target = 0
        val actual = findSumOfThree(nums, target)
        assertTrue(actual)
    }
}
