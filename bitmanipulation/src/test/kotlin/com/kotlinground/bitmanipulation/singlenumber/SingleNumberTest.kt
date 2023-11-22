package com.kotlinground.bitmanipulation.singlenumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SingleNumberTest {
    @Test
    fun `should return 1 from nums = (2,2,1)`() {
        val nums = intArrayOf(2, 2, 1)
        val expected = 1
        val actual = singleNumber(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from nums = (4,1,2,1,2)`() {
        val nums = intArrayOf(4, 1, 2, 1, 2)
        val expected = 4
        val actual = singleNumber(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from nums = (1)`() {
        val nums = intArrayOf(1)
        val expected = 1
        val actual = singleNumber(nums)
        assertEquals(expected, actual)
    }
}

class SingleNumberMathTest {
    @Test
    fun `should return 1 from nums = (2,2,1)`() {
        val nums = intArrayOf(2, 2, 1)
        val expected = 1
        val actual = singleNumberMath(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 from nums = (4,1,2,1,2)`() {
        val nums = intArrayOf(4, 1, 2, 1, 2)
        val expected = 4
        val actual = singleNumberMath(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from nums = (1)`() {
        val nums = intArrayOf(1)
        val expected = 1
        val actual = singleNumberMath(nums)
        assertEquals(expected, actual)
    }
}