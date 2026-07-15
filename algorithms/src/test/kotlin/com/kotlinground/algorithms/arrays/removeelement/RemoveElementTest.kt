package com.kotlinground.algorithms.arrays.removeelement

import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveElementTest {

    @Test
    fun `Should return 2 for nums = 3,2,2,3 and val = 3`() {
        val nums = intArrayOf(3, 2, 2, 3)
        val n = 3
        val actual = removeElement(nums, n)
        val expected = 2
        assertEquals(expected, actual)
    }
}

class RemoveDuplicateTest {

    @Test
    fun `Should return 5 for nums = 1,1,1,2,2,3`() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val expected = 5
        val actual = removeDuplicates(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return 7 for nums = 0,0,1,1,1,1,2,3,3`() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val expected = 7
        val actual = removeDuplicates(nums)
        assertEquals(expected, actual)
    }
}
