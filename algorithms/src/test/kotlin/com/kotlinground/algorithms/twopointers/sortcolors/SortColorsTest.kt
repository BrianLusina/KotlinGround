package com.kotlinground.algorithms.twopointers.sortcolors

import kotlin.test.Test
import kotlin.test.assertContentEquals

class SortColorsTest {
    @Test
    fun `should sort colors = (1,0,2,1,2,2) to (0,1,1,2,2,2)`() {
        val colors = intArrayOf(1, 0, 2, 1, 2, 2)
        val expected = intArrayOf(0, 1, 1, 2, 2, 2)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (0,1,1,2,0,2,0,2,1,2) to (0,0,0,1,1,1,2,2,2,2)`() {
        val colors = intArrayOf(0,1,1,2,0,2,0,2,1,2)
        val expected = intArrayOf(0,0,0,1,1,1,2,2,2,2)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (0) to (0)`() {
        val colors = intArrayOf(0)
        val expected = intArrayOf(0)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (0,1,0) to (0,0,1)`() {
        val colors = intArrayOf(0,1,0)
        val expected = intArrayOf(0,0,1)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (1) to (1)`() {
        val colors = intArrayOf(1)
        val expected = intArrayOf(1)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (2,2) to (2,2)`() {
        val colors = intArrayOf(2,2)
        val expected = intArrayOf(2,2)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (1,1,0,2) to (0,1,1,2)`() {
        val colors = intArrayOf(1,1,0,2)
        val expected = intArrayOf(0,1,1,2)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should sort colors = (2,1,1,0,0) to (0,0,1,1,2)`() {
        val colors = intArrayOf(2,1,1,0,0)
        val expected = intArrayOf(0,0,1,1,2)
        val actual = sortColors(colors)
        assertContentEquals(expected, actual)
    }
}
