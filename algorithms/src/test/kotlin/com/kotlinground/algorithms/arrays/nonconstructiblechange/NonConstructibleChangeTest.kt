package com.kotlinground.algorithms.arrays.nonconstructiblechange

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NonConstructibleChangeTest {
    @Test
    fun `should return 20 from (5, 7, 1, 1, 2, 3, 22)`() {
        val coins = mutableListOf(5, 7, 1, 1, 2, 3, 22)
        val expected = 20
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 6 from (1, 1, 1, 1, 1)`() {
        val coins = mutableListOf(1, 1, 1, 1, 1)
        val expected = 6
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 55 from (1, 5, 1, 1, 1, 10, 15, 20, 100)`() {
        val coins = mutableListOf(1, 5, 1, 1, 1, 10, 15, 20, 100)
        val expected = 55
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 from (6, 4, 5, 1, 1, 8, 9)`() {
        val coins = mutableListOf(6, 4, 5, 1, 1, 8, 9)
        val expected = 3
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }
    @Test
    fun `should return 1 from ()`() {
        val coins = mutableListOf<Int>()
        val expected = 1
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from (87)`() {
        val coins = mutableListOf(87)
        val expected = 1
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 32 from (5, 6, 1, 1, 2, 3, 4, 9)`() {
        val coins = mutableListOf(5, 6, 1, 1, 2, 3, 4, 9)
        val expected = 32
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 19 from (5, 6, 1, 1, 2, 3, 43)`() {
        val coins = mutableListOf(5, 6, 1, 1, 2, 3, 43)
        val expected = 19
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 from (2)`() {
        val coins = mutableListOf(2)
        val expected = 1
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 from (1, 1)`() {
        val coins = mutableListOf(1, 1)
        val expected = 3
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 87 from (109, 2000, 8765, 19, 18, 17, 16, 8, 1, 1, 2, 4)`() {
        val coins = mutableListOf(109, 2000, 8765, 19, 18, 17, 16, 8, 1, 1, 2, 4)
        val expected = 87
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 29 from (1, 2, 3, 4, 5, 6, 7)`() {
        val coins = mutableListOf(1, 2, 3, 4, 5, 6, 7)
        val expected = 29
        val actual = nonConstructibleChange(coins)
        assertEquals(expected, actual)
    }

    @Test
    fun `should not mutate the input coins list`() {
        val coins = mutableListOf(5, 7, 1, 1, 2, 3, 22)
        val snapshot = coins.toList()
        nonConstructibleChange(coins)
        assertEquals(coins, snapshot)
    }
}
