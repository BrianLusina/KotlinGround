package com.kotlinground.algorithms.intervals.taskscheduler

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class TaskSchedulerTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(listOf("A", "A", "B", "B"), 2, 5),
            Arguments.of(listOf("A", "B", "A", "A", "B", "C"), 3, 9),
            Arguments.of(listOf("A", "C", "B", "A"), 0, 4),
            Arguments.of(listOf("A", "A", "A", "B", "B", "C", "C"), 1, 7),
            Arguments.of(listOf("S", "I", "V", "U", "W", "D", "U", "X"), 0, 8),
            Arguments.of(listOf("A", "K", "X", "M", "W", "D", "X", "B", "D", "C", "O", "Z", "D", "E", "Q"), 3, 15),
            Arguments.of(listOf("A", "B", "C", "O", "Q", "C", "Z", "O", "X", "C", "W", "Q", "Z", "B", "M", "N", "R", "L", "C", "J",), 10, 34),
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `least interval task scheduler using mathematical approach`(tasks: List<String>, n: Int, expected: Int) {
        val actual = leastIntervalsMathematical(tasks, n)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `least interval task scheduler using max heap`(tasks: List<String>, n: Int, expected: Int) {
        val actual = leastIntervalsMaxHeap(tasks, n)
        assertEquals(expected, actual)
    }
}