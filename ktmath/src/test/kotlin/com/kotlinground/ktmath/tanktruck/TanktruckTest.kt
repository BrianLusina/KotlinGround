package com.kotlinground.ktmath.tanktruck

import org.junit.Assert.assertEquals
import org.junit.Test

class TanktruckTest {
    @Test
    fun test0() {
        println("Fixed Tests")
        assertEquals(2940, tankVol(5, 7, 3848))
        assertEquals(245, tankVol(1, 4, 1256))
    }
}