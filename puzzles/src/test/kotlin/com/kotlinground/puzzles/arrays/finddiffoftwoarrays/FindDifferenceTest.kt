package com.kotlinground.puzzles.arrays.finddiffoftwoarrays

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class FindDifferenceTest {
    @Test
    fun `should return 1,3_,4,6 from nums1 = 1,2,3, nums2 = 2,4,6`() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(2, 4, 6)
        val expected = listOf(listOf(1, 3), listOf(4, 6))
        val actual = findDifference(nums1, nums2)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return 3_,_ from nums1 = 1,2,3,3, nums2 = 1,1,2,2`() {
        val nums1 = intArrayOf(1, 2, 3, 3)
        val nums2 = intArrayOf(1, 1, 2, 2)
        val expected = listOf(listOf(3), listOf())
        val actual = findDifference(nums1, nums2)
        assertContentEquals(expected, actual)
    }
}
