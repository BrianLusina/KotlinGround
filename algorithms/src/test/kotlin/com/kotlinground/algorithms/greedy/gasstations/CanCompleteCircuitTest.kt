package com.kotlinground.algorithms.greedy.gasstations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CanCompleteCircuitTest {
    @Test
    fun `should return 3 for gas = (1, 2, 3, 4, 5), cost = (3, 4, 5, 1, 2)`() {
        val gas = intArrayOf(1, 2, 3, 4, 5)
        val cost = intArrayOf(3, 4, 5, 1, 2)
        val expected = 3
        val actual = canCompleteCircuit(gas, cost)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return -1 for gas = (2, 3, 4), cost = (3, 4, 3)`() {
        val gas = intArrayOf(2, 3, 4)
        val cost = intArrayOf(3, 4, 3)
        val expected = -1
        val actual = canCompleteCircuit(gas, cost)
        assertEquals(expected, actual)
    }
}
