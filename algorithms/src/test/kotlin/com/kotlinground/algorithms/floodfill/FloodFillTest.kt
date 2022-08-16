package com.kotlinground.algorithms.floodfill

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class FloodFillTest {
    @Test
    fun `should return same grid if starting pixel is same as new color`() {
        val image = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        val sr = 0
        val sc = 0
        val color = 0
        val actual = floodFill(image, sr, sc, color)
        val expected = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return new grid ((2, 2, 2), (2, 2, 0), (2, 0, 1)) with new color for ((1,1,1),(1,1,0),(1,0,1)), sr = 1, sc = 1, color = 2`() {
        val image = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
        val sr = 1
        val sc = 1
        val color = 2
        val actual = floodFill(image, sr, sc, color)
        val expected = arrayOf(intArrayOf(2, 2, 2), intArrayOf(2, 2, 0), intArrayOf(2, 0, 1))
        assertContentEquals(expected, actual)
    }
}
