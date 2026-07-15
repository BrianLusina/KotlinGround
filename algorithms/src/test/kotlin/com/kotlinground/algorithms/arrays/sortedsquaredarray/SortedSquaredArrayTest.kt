package com.kotlinground.algorithms.arrays.sortedsquaredarray

import kotlin.test.Test
import kotlin.test.assertEquals

class SortedSquaredArrayTest {
    @Test
    fun `For an input of (1,2,3,5,6,8,9) it should return (1, 4, 9,25, 36, 64, 81)`() {
        val nums = listOf(1,2,3,5,6,8,9)
        val expected = listOf(1, 4, 9,25, 36, 64, 81)
        val actual = sortedSquaredArray(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `For an input of (1) it should return (1)`() {
        val nums = listOf(1)
        val expected = listOf(1)
        val actual = sortedSquaredArray(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `For an input of (-7,-3,2,3,11) it should return (4,9,9,49,121)`() {
        val nums = listOf(-7,-3,2,3,11)
        val expected = listOf(4,9,9,49,121)
        val actual = sortedSquaredArray(nums)
        assertEquals(expected, actual)
    }
}

