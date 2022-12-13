package com.kotlinground.algorithms.searching.binary.rotatedsortedarray

import org.junit.Test
import kotlin.test.assertEquals

class RotatedSortedArrayTest {
    @Test
    fun `Should return 4 for nums 4_5_6_7_0_1_2 and target = 0`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target = 0
        val expected = 4
        val actual = search(nums, target)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return -1 for nums = 4_5_6_7_0_1_2 and target = 3`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target = 3
        val expected = -1
        val actual = search(nums, target)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return -1 for nums = 1 and target = 0`() {
        val nums = intArrayOf(1)
        val target = 0
        val expected = -1
        val actual = search(nums, target)
        assertEquals(expected, actual)
    }
}
