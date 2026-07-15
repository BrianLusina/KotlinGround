package com.kotlinground.algorithms.twopointers.mergesortedarray

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class MergeTest {
    @Test
    fun `should do nothing for empty arrays`() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf()
        merge(nums1, 0, nums2, 0)
        val expected = intArrayOf()
        assertContentEquals(expected, nums1)
    }

    @Test
    fun `should set nums1 to (1,2,2,3,5,6) when initially nums1 = (1,2,3,0,0,0), m = 3, nums2 = (2,5,6), n = 3`() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(2, 5, 6)
        val n = 3
        val expected = intArrayOf(1, 2, 2, 3, 5, 6)
        merge(nums1, m, nums2, n)
        assertContentEquals(expected, nums1)
    }

    @Test
    fun `should set nums1 to (1) when initially nums1 = (0), m = 0, nums2 = (1), n = 1`() {
        val nums1 = intArrayOf(0)
        val m = 0
        val nums2 = intArrayOf(1)
        val n = 1
        val expected = intArrayOf(1)
        merge(nums1, m, nums2, n)
        assertContentEquals(expected, nums1)
    }
}
