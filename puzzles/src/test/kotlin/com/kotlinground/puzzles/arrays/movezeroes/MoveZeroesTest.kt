package com.kotlinground.puzzles.arrays.movezeroes

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class MoveZeroesTest {
    @Test
    fun `should modify nums = 0, 1, 0, 3, 12 in place to 1,3,12,0,0`() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        val expected = intArrayOf(1, 3, 12, 0, 0)
        moveZeroes(nums)
        assertContentEquals(expected, nums)
    }

    @Test
    fun `should modify nums = 0 in place to 0`() {
        val nums = intArrayOf(0)
        val expected = intArrayOf(0)
        moveZeroes(nums)
        assertContentEquals(expected, nums)
    }

    @Test
    fun `should modify nums = 1,0 in place to 1,0`() {
        val nums = intArrayOf(1, 0)
        val expected = intArrayOf(1, 0)
        moveZeroes(nums)
        assertContentEquals(expected, nums)
    }
}

class MoveZeroesOneTest {
    @Test
    fun `should modify nums = 0, 1, 0, 3, 12 in place to 1,3,12,0,0`() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        val expected = intArrayOf(1, 3, 12, 0, 0)
        moveZeroesOne(nums)
        assertContentEquals(expected, nums)
    }

    @Test
    fun `should modify nums = 0 in place to 0`() {
        val nums = intArrayOf(0)
        val expected = intArrayOf(0)
        moveZeroesOne(nums)
        assertContentEquals(expected, nums)
    }

    @Test
    fun `should modify nums = 1,0 in place to 1,0`() {
        val nums = intArrayOf(1, 0)
        val expected = intArrayOf(1, 0)
        moveZeroesOne(nums)
        assertContentEquals(expected, nums)
    }
}
