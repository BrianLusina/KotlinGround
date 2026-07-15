package com.kotlinground.algorithms.arrays.optimaltasks

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class OptimalTaskAssignmentTest {
    @Test
    fun `should return ((2,7), (3,6),(5,5)) from (6, 3, 2, 7, 5, 5)`() {
        val tasks = listOf(6, 3, 2, 7, 5, 5)
        val expected = listOf(Pair(2, 7), Pair(3, 6), Pair(5, 5))
        val actual = optimalTaskAssignment(tasks)
        assertEquals(expected, actual)
    }
}
