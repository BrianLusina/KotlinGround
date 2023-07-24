package com.kotlinground.puzzles.stack.asteroidcollision

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class AsteroidCollisionTest {
    @Test
    fun `should return 5, 10 from 5, 10,-5`() {
        val asteroids = intArrayOf(5, 10, -5)
        val expected = intArrayOf(5, 10)
        val actual = asteroidCollision(asteroids)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return empty array from 8, -8`() {
        val asteroids = intArrayOf(8, -8)
        val expected = intArrayOf()
        val actual = asteroidCollision(asteroids)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return 10 from 10, 2, -5`() {
        val asteroids = intArrayOf(10, 2, -5)
        val expected = intArrayOf(10)
        val actual = asteroidCollision(asteroids)
        assertContentEquals(expected, actual)
    }
}
