package com.kotlinground.ktmath.primes.backwardsreadprimes

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class BackwardsReadPrimesTest {
    @Test
    fun `Should return 7027 7043 7057 for start = 7000 and end = 7100`() {
        assertEquals("7027 7043 7057", backwardsPrime(7000L, 7100L))
    }

    @Test
    fun `Should return 70001 70009 70061 70079 70121 70141 70163 70241 for start = 70000 and end = 70245`() {
        assertEquals("70001 70009 70061 70079 70121 70141 70163 70241", backwardsPrime(70000L, 70245L))
    }
}