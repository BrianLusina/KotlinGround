package com.kotlinground.puzzles.arrays.highestaltitude

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LargestAltitudeTest {
    @Test
    fun `should return 1 from gain=-5,1,5,0,-7`() {
        val gain = intArrayOf(-5, 1, 5, 0, -7)
        val expected = 1
        val actual = largestAltitude(gain)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 from gain=-4,-3,-2,-1,4,3,2`() {
        val gain = intArrayOf(-4, -3, -2, -1, 4, 3, 2)
        val expected = 0
        val actual = largestAltitude(gain)
        assertEquals(expected, actual)
    }
}