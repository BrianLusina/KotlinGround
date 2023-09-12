package com.kotlinground.puzzles.graph.numberofprovinces

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfProvincesTest {
    @Test
    fun `should return 0 for an empty grid`() {
        val isConnected = arrayOf(intArrayOf())
        val expected = 0
        val actual = numberOfProvinces(isConnected)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 for a grid of ((1,1,0),(1,1,0),(0,0,1))`() {
        val isConnected = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
        val expected = 2
        val actual = numberOfProvinces(isConnected)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for a grid of ((1,0,0),(0,1,0),(0,0,1))`() {
        val isConnected = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))
        val expected = 3
        val actual = numberOfProvinces(isConnected)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 for a grid of ((1,1,1), (1,1,1), (1,1,1))`() {
        val isConnected = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        val expected = 1
        val actual = numberOfProvinces(isConnected)
        assertEquals(expected, actual)
    }
}
