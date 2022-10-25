package com.kotlinground.algorithms.numberofislands

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfIslandsTest {

    @Test
    fun `should return 1 for a grid of (("1","1","1","1","0"),("1","1","0","1","0"),("1","1","0","0","0"),("0","0","0","0","0"))`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )
        val expected = 1
        val actual = numIslands(grid)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for a grid of (("1", "1", "0", "0", "0"),("1", "1", "0", "0", "0"),("0", "0", "1", "0", "0"),("0", "0", "0", "1", "1"))`() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )
        val expected = 3
        val actual = numIslands(grid)
        assertEquals(expected, actual)
    }
}
