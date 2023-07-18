package com.kotlinground.puzzles.hashmap.equalrowsandcolumns

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualPairsTest {

    @Test
    fun `should return 1 from 3,2,1, 1,7,6, 2,7,7`() {
        val grid = arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7))
        val expected = 1
        val actual = equalPairsHashMap(grid)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 from 3,1,2,2 , 1,4,4,5, 2,4,2,2, 2,4,2,2`() {
        val grid =
            arrayOf(intArrayOf(3, 1, 2, 2), intArrayOf(1, 4, 4, 5), intArrayOf(2, 4, 2, 2), intArrayOf(2, 4, 2, 2))
        val expected = 3
        val actual = equalPairsHashMap(grid)
        assertEquals(expected, actual)
    }
}

class EqualPairsBruteForceTest {

    @Test
    fun `should return 1 from 3,2,1, 1,7,6, 2,7,7`() {
        val grid = arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7))
        val expected = 1
        val actual = equalPairsBruteForce(grid)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 from 3,1,2,2 , 1,4,4,5, 2,4,2,2, 2,4,2,2`() {
        val grid =
            arrayOf(intArrayOf(3, 1, 2, 2), intArrayOf(1, 4, 4, 5), intArrayOf(2, 4, 2, 2), intArrayOf(2, 4, 2, 2))
        val expected = 3
        val actual = equalPairsBruteForce(grid)
        assertEquals(expected, actual)
    }
}

class EqualPairsTrieNodeTest {

    @Test
    fun `should return 1 from 3,2,1, 1,7,6, 2,7,7`() {
        val grid = arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7))
        val expected = 1
        val actual = equalPairsTrieNode(grid)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 3 from 3,1,2,2 , 1,4,4,5, 2,4,2,2, 2,4,2,2`() {
        val grid =
            arrayOf(intArrayOf(3, 1, 2, 2), intArrayOf(1, 4, 4, 5), intArrayOf(2, 4, 2, 2), intArrayOf(2, 4, 2, 2))
        val expected = 3
        val actual = equalPairsTrieNode(grid)
        assertEquals(expected, actual)
    }
}
