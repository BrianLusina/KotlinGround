package com.kotlinground.puzzles.arrays.jumpgame

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class CanJumpTest {
    @Test
    fun `should return true for nums = (2,3,1,1,4)`() {
        val nums = intArrayOf(2, 3, 1, 1, 4)
        val actual = canJump(nums)
        assertTrue(actual)
    }

    @Test
    fun `should return false for nums = (3, 2, 1, 0, 4)`() {
        val nums = intArrayOf(3, 2, 1, 0, 4)
        val actual = canJump(nums)
        assertFalse(actual)
    }
}
