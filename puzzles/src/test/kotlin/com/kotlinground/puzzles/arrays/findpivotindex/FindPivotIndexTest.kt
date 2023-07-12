package com.kotlinground.puzzles.arrays.findpivotindex

import com.kotlinground.puzzles.prefixsum.findpivotindex.pivotIndex
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindPivotIndexTest {
    @Test
    fun `should return 3 from nums=1,7,3,6,5,6`() {
        val nums = intArrayOf(1, 7, 3, 6, 5, 6)
        val expected = 3
        val actual = pivotIndex(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 from nums=2,1,-1`() {
        val nums = intArrayOf(2, 1, -1)
        val expected = 0
        val actual = pivotIndex(nums)
        assertEquals(expected, actual)
    }
}
