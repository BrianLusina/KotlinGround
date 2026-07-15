package com.kotlinground.puzzles.arrays.jumpgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpTest {
    @Test
    fun `should return 2 for nums = (2,3,1,1,4)`() {
        val nums = intArrayOf(2, 3, 1, 1, 4)
        val actual = jump(nums)
        val expected = 2
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 for nums = (2, 3, 0, 1, 4)`() {
        val nums = intArrayOf(2, 3, 0, 1, 4)
        val actual = jump(nums)
        val expected = 2
        assertEquals(expected, actual)
    }
}
