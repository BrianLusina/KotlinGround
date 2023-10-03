package com.kotlinground.puzzles.graph.rottingoranges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrangesRottingTest {
    @Test
    fun `should return 4 for grid = ((2,1,1), (1,1,0), (0,1,1))`() {
        val grid = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))
        val expected = 4
        val actual = orangesRotting(grid)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return -1 for grid = ((2,1,1),(0,1,1),(1,0,1))`() {
        val grid = arrayOf(intArrayOf(2, 1, 1), intArrayOf(0, 1, 1), intArrayOf(1, 0, 1))
        val expected = -1
        val actual = orangesRotting(grid)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 for grid = ((0,2))`() {
        val grid = arrayOf(intArrayOf(0, 2))
        val expected = 0
        val actual = orangesRotting(grid)
        assertEquals(expected, actual)
    }
}
