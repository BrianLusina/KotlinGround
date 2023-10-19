package com.kotlinground.puzzles.search.binarysearch.successfulpairsspellspotions

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SuccessfulPairsTest {
    @Test
    fun `spells = (5,1,3), potions = (1,2,3,4,5), success = 7 should return (4,0,3)`() {
        val spells = intArrayOf(5, 1, 3)
        val potions = intArrayOf(1, 2, 3, 4, 5)
        val success = 7L
        val expected = intArrayOf(4, 0, 3)
        val actual = successfulPairs(spells, potions, success)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `spells = (3, 1, 2), potions = (8,5,8), success = 16 should return (2,0,2)`() {
        val spells = intArrayOf(3, 1, 1)
        val potions = intArrayOf(8, 5, 8)
        val success = 16L
        val expected = intArrayOf(2, 0, 2)
        val actual = successfulPairs(spells, potions, success)
        assertContentEquals(expected, actual)
    }
}

class SuccessfulPairs2Test {
    @Test
    fun `spells = (5,1,3), potions = (1,2,3,4,5), success = 7 should return (4,0,3)`() {
        val spells = intArrayOf(5, 1, 3)
        val potions = intArrayOf(1, 2, 3, 4, 5)
        val success = 7L
        val expected = intArrayOf(4, 0, 3)
        val actual = successfulPairs2(spells, potions, success)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `spells = (3, 1, 2), potions = (8,5,8), success = 16 should return (2,0,2)`() {
        val spells = intArrayOf(3, 1, 2)
        val potions = intArrayOf(8, 5, 8)
        val success = 16L
        val expected = intArrayOf(2, 0, 2)
        val actual = successfulPairs2(spells, potions, success)
        assertContentEquals(expected, actual)
    }
}
