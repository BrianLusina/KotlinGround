package com.kotlinground.puzzles.search.binarysearch.kokoeatingbananas

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinEatingSpeedTest {
    @Test
    fun `should return 4 for piles = (3, 6, 7, 11) h = 8`() {
        val piles = intArrayOf(3, 6, 7, 11)
        val h = 8
        val expected = 4
        val actual = minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 30 for piles = (30, 11, 23, 4, 20) h = 5`() {
        val piles = intArrayOf(30, 11, 23, 4, 20)
        val h = 5
        val expected = 30
        val actual = minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 23 for piles = (30, 11, 23, 4, 20) h = 6`() {
        val piles = intArrayOf(30, 11, 23, 4, 20)
        val h = 6
        val expected = 23
        val actual = minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 for piles = (2, 2) h = 2`() {
        val piles = intArrayOf(2, 2)
        val h = 2
        val expected = 2
        val actual = minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 500000000 for piles = (1000000000) h = 2`() {
        val piles = intArrayOf(1000000000)
        val h = 2
        val expected = 500000000
        val actual = minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 for piles = (805306368,805306368,805306368) h = 1000000000`() {
        val piles = intArrayOf(805306368, 805306368, 805306368)
        val h = 1000000000
        val expected = 3
        val actual = minEatingSpeed(piles, h)
        assertEquals(expected, actual)
    }
}