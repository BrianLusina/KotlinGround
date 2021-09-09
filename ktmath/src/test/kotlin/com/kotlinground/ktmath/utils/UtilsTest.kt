package com.kotlinground.ktmath.utils

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class UtilsTest {

    @Test
    fun `Should reverse 7027 and return 7207`() {
        val n = 7027
        val expected = 7207
        val actual = Utils.reverseInt(n)
        assertEquals(expected, actual)
    }

    @Test
    fun `Should reverse 7000 and return 7`() {
        val n = 7000
        val expected = 7
        val actual = Utils.reverseInt(n)
        assertEquals(expected, actual)
    }
}
