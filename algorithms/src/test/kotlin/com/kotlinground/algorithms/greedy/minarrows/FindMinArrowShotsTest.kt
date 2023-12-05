package com.kotlinground.algorithms.greedy.minarrows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinArrowShotsTest {
    @Test
    fun `points = ((10,16), (2,8), (1,6), (7,12)) should return 2`() {
        val points = arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(1, 6), intArrayOf(7, 12))
        val expected = 2
        val actual = findMinArrowShots(points)
        assertEquals(expected, actual)
    }

    @Test
    fun `points = ((1,2), (3,4), (5,6), (7,8)) should return 4`() {
        val points = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6), intArrayOf(7, 8))
        val expected = 4
        val actual = findMinArrowShots(points)
        assertEquals(expected, actual)
    }

    @Test
    fun `points = ((1,2), (2,3), (3,4), (4,5)) should return 2`() {
        val points = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5))
        val expected = 2
        val actual = findMinArrowShots(points)
        assertEquals(expected, actual)
    }
}
