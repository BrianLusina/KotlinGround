package com.kotlinground.algorithms.maxareaofisland

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxAreaOfIslandTest {
    @Test
    fun `should return 6 for a grid of ((0,0,1,0,0,0,0,1,0,0,0,0,0),(0,0,0,0,0,0,0,1,1,1,0,0,0),(0,1,1,0,1,0,0,0,0,0,0,0,0),(0,1,0,0,1,1,0,0,1,0,1,0,0),(0,1,0,0,1,1,0,0,1,1,1,0,0),(0,0,0,0,0,0,0,0,0,0,1,0,0),(0,0,0,0,0,0,0,1,1,1,0,0,0),(0,0,0,0,0,0,0,1,1,0,0,0,0))`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
        )
        val expected = 6
        val actual = maxAreaOfIsland(grid)

        assertEquals(expected, actual)
    }
}
