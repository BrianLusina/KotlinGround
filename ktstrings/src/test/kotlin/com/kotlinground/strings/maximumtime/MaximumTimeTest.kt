package com.kotlinground.strings.maximumtime

import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumTimeTest {

    @Test
    fun `Should return 2350 from 2??0`() {
        val time = "2?:?0"
        val expected = "23:50"
        val actual = maximumTime(time)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return 1?22 from 1922`() {
        val time = "1?:22"
        val expected = "19:22"
        val actual = maximumTime(time)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return the maximum time 0939 from 0?3?`() {
        val time = "0?:3?"
        val expected = "09:39"
        val actual = maximumTime(time)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should return the maximum time 2339 from ??3?`() {
        val time = "??:3?"
        val expected = "23:39"
        val actual = maximumTime(time)
        assertEquals(expected, actual)
    }
}
