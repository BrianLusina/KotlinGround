package com.kotlinground.ktmath.circleofnumbers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CircleofnumbersKtTest {
    @Test
    fun `Should return 7 for n is 10 and first number is 2`() {
        Assertions.assertEquals(7, circleOfNumbers(10, 2))
    }

    @Test
    fun `Should return 2 for n is 10 and first number is 7`() {
        Assertions.assertEquals(2, circleOfNumbers(10, 7))
    }

    @Test
    fun `Should return 3 for n is 4 and first number is 1`() {
        Assertions.assertEquals(3, circleOfNumbers(4, 1))
    }

    @Test
    fun `Should return 0 for n is 6 and first number is 3`() {
        Assertions.assertEquals(0, circleOfNumbers(6, 3))
    }
}