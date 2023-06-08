package com.kotlinground.puzzles.arrays.canplaceflowers

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CanPlaceFlowersTest {
    @Test
    fun `should return true for flowerbed=1, 0, 0, 0, 1 and n=1`() {
        val flowerbed = intArrayOf(1, 0, 0, 0, 1)
        val n = 1
        val actual = canPlaceFlowers(flowerbed, n)
        assertTrue(actual)
    }

    @Test
    fun `should return false for flowerbed=1, 0, 0, 0, 1 and n=2`() {
        val flowerbed = intArrayOf(1, 0, 0, 0, 1)
        val n = 2
        val actual = canPlaceFlowers(flowerbed, n)
        assertFalse(actual)
    }
}

class CanPlaceFlowers2Test {
    class CanPlaceFlowersTest {
        @Test
        fun `should return true for flowerbed=1, 0, 0, 0, 1 and n=1`() {
            val flowerbed = intArrayOf(1, 0, 0, 0, 1)
            val n = 1
            val actual = canPlaceFlowers2(flowerbed, n)
            assertTrue(actual)
        }

        @Test
        fun `should return false for flowerbed=1, 0, 0, 0, 1 and n=2`() {
            val flowerbed = intArrayOf(1, 0, 0, 0, 1)
            val n = 2
            val actual = canPlaceFlowers2(flowerbed, n)
            assertFalse(actual)
        }
    }
}
