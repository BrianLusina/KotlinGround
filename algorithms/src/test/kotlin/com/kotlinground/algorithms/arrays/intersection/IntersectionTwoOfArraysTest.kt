package com.kotlinground.algorithms.arrays.intersection

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class IntersectionTwoOfArraysTest {

    @Test
    fun `Should return (2,2) for nums1=(1,2,2,1) and nums2=(2,2)`() {
        val nums1 = arrayOf(1, 2, 2, 1)
        val nums2 = arrayOf(2, 2)
        val expected = listOf(2, 2)
        assertContentEquals(expected, intersectionTwo(nums1, nums2))
    }

    @Test
    fun `Should return (9,4) or (4, 9) for nums1=(4,9,5) and nums2=(9,4,9,8,4)`() {
        val nums1 = arrayOf(4, 9, 5)
        val nums2 = arrayOf(9, 4, 9, 8, 4)
        val expected = listOf(9, 4)
        assertContentEquals(expected, intersectionTwo(nums1, nums2))
    }

}