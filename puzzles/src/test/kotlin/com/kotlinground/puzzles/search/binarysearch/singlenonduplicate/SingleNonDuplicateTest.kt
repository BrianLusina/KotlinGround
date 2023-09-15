package com.kotlinground.puzzles.search.binarysearch.singlenonduplicate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNonDuplicateTest {
    @Test
    fun `should return 2 for (1,1,2,3,3,4,4,8,8)`() {
        val nums = intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)
        val expected = 2
        val actual = singleNonDuplicate(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 10 for (3,3,7,7,10,11,11)`() {
        val nums = intArrayOf(3, 3, 7, 7, 10, 11, 11)
        val expected = 10
        val actual = singleNonDuplicate(nums)
        assertEquals(expected, actual)
    }
}
