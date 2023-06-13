package com.kotlinground.puzzles.arrays.productofarrayexceptself

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProductOfArrayExceptSelfTest {
    @Test
    fun `should return true for flowerbed=1, 0, 0, 0, 1 and n=1`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val expected = intArrayOf(24, 12, 8, 6)
        val actual = productExceptSelf(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return false for flowerbed=1, 0, 0, 0, 1 and n=2`() {
        val nums = intArrayOf(-1, 1, 0, -3, 3)
        val expected = intArrayOf(0, 0, 9, 0, 0)
        val actual = productExceptSelf(nums)
        assertEquals(expected, actual)
    }
}