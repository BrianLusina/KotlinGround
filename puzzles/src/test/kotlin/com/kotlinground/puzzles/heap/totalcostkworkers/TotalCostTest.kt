package com.kotlinground.puzzles.heap.totalcostkworkers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCostTest {
    @Test
    fun `should return 11 for costs = (17,12,10,2,7,2,11,20,8), k = 3, candidates = 4`() {
        val costs = intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8)
        val k = 3
        val candidates = 4
        val expected = 11L
        val actual = totalCost(costs = costs, k = k, candidates = candidates)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 4 costs = (1,2,4,1), k = 3, candidates = 3`() {
        val costs = intArrayOf(1, 2, 4, 1)
        val k = 3
        val candidates = 3
        val expected = 4L
        val actual = totalCost(costs = costs, k = k, candidates = candidates)
        assertEquals(expected, actual)
    }
}
