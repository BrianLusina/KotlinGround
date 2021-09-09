package com.kotlinground.ktmath.primes


import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class IsPrimeTest {

    @Test
    fun `Should return true for 3`() {
        val n = 3
        val actual = isPrime(n)
        assertTrue(actual)
    }

    @Test
    fun `Should return true for 7001`() {
        val n = 7001
        val actual = isPrime(n)
        assertTrue(actual)
    }
}