package com.kotlinground.puzzles.graph.courseschedule

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class CourseScheduleTest {
    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of(2, arrayOf(intArrayOf(1, 0)), true),
            Arguments.of(4, arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2)), true),
            Arguments.of(1, arrayOf<IntArray>(), true),
            Arguments.of(3, arrayOf(intArrayOf(1,0), intArrayOf(2,1), intArrayOf(1, 2)), false),
            Arguments.of(3, arrayOf(intArrayOf(1,0), intArrayOf(2,1), intArrayOf(4, 3)), true),
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `can finish course schedule`(numCourses: Int, prerequisites: Array<IntArray>, expected: Boolean) {
        val actual = canFinish(numCourses, prerequisites)
        assertEquals(expected, actual)
    }
}
