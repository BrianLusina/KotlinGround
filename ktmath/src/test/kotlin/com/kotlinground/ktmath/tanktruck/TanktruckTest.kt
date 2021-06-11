package com.kotlinground.ktmath.tanktruck

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TanktruckTest {
    @Test
    fun test0() {
        assertEquals(2940, tankVol(5, 7, 3848))
        assertEquals(245, tankVol(1, 4, 1256))
    }
}
