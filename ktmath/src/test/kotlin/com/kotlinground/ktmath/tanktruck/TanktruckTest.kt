package com.kotlinground.ktmath.tanktruck

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TanktruckTest {
    @Test
    fun `Should return 2940 for height of 5 and diameter of 7 and volume of 3848`() {
        assertEquals(2940, tankVol(5, 7, 3848))
    }

    @Test
    fun `Should return 245 for height of 1 and diameter of 4 and volume of 1256`() {
        assertEquals(245, tankVol(1, 4, 1256))
    }
}
