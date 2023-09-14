package com.kotlinground.puzzles.graph.reorderroutes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReorderRoutesTest {
    @Test
    fun `should return 3 from input n = 6, connections = ((0,1), (1,3), (2,3), (4,0), (4,5))`() {
        val connections =
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(4, 0), intArrayOf(4, 5))
        val n = 6
        val expected = 3
        val actual = minReorder(n, connections)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from input n = 5, connections = ((1,0), (1,2), (3,2), (4,0), (3,4))`() {
        val connections =
            arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(3, 4))
        val n = 5
        val expected = 2
        val actual = minReorder(n, connections)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0 from input n = 3, connections = ((1,0), (2,0))`() {
        val connections =
            arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(3, 4))
        val n = 3
        val expected = 0
        val actual = minReorder(n, connections)
        assertEquals(expected, actual)
    }
}