package com.kotlinground.datastructures.sparsevector

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class SparseVectorTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(
                intArrayOf(1, 0, 0, 2, 3),
                intArrayOf(0, 3, 0, 4, 0),
                8
            )
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `dot product of sparse vectors`(a: IntArray, b: IntArray, expected: Int) {
        val sparseVectorA = SparseVector(a)
        val sparseVectorB = SparseVector(b)
        val actual = sparseVectorA.dotProduct(sparseVectorB)
        assertEquals(expected, actual)
    }
}
