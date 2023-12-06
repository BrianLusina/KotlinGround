package com.kotlinground.algorithms.stack.dailytemperatures

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class DailyTemperaturesTest {
    @Test
    fun `should return (1,1,4,2,1,1,0,0) for (73, 74, 75, 71, 69, 72, 76, 73)`() {
        val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
        val actual = dailyTemperatures(temperatures)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return (1,1,1,0) for (30,40,50,60)`() {
        val temperatures = intArrayOf(30, 40, 50, 60)
        val expected = intArrayOf(1, 1, 1, 0)
        val actual = dailyTemperatures(temperatures)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return (1,1,0) for (30,60,90)`() {
        val temperatures = intArrayOf(30, 60, 90)
        val expected = intArrayOf(1, 1, 0)
        val actual = dailyTemperatures(temperatures)
        assertContentEquals(expected, actual)
    }
}
