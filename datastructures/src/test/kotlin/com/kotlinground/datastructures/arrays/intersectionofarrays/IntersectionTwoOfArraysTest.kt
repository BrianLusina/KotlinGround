package com.kotlinground.datastructures.arrays.intersectionofarrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntersectionTwoOfArraysTest {

    @Test
    fun `Should return (2,2) for nums1=(1,2,2,1) and nums2=(2,2)`() {
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2, 2)
        val expected = intArrayOf(2, 2)
        assertArrayEquals(expected, intersectionTwo(nums1, nums2))
    }

    @Test
    fun `Should return (9,4) or (4, 9) for nums1=(4,9,5) and nums2=(9,4,9,8,4)`() {
        val nums1 = intArrayOf(4, 9, 5)
        val nums2 = intArrayOf(9, 4, 9, 8, 4)
        val expected = intArrayOf(9, 4)
        assertArrayEquals(expected, intersectionTwo(nums1, nums2))
    }

}