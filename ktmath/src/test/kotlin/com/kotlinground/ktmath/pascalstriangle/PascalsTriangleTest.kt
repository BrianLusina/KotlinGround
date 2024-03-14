package com.kotlinground.ktmath.pascalstriangle

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class PascalsTriangleTest {
    @Test
    fun `k=3 should return (1, 3, 3, 1)`() {
        val k = 3
        val expected = arrayListOf(1, 3, 3, 1)
        val actual = pascalsNthRow(k)
        assertContentEquals(expected, actual)
    }
}
