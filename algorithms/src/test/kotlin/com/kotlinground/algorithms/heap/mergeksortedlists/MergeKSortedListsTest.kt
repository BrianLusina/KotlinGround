package com.kotlinground.algorithms.heap.mergeksortedlists

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

class MergeKSortedListsTest {
    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of(
                listOf(
                    listOf(3, 4, 6),
                    listOf(2, 3, 5),
                    listOf(-1, 6)
                ),
                listOf(-1, 2, 3, 3, 4, 5, 6, 6)
            ),
            Arguments.of(
                listOf(
                    listOf(2, 4, 6),
                    listOf(1, 3, 5),
                ),
                listOf(1, 2, 3, 4, 5, 6)
            ),
            Arguments.of(
                listOf(
                    listOf(1, 4, 5),
                    listOf(1, 3, 4),
                    listOf(2, 6),
                ),
                listOf(1, 1, 2, 3, 4, 4, 5, 6)
            ),
            Arguments.of(
                listOf<Int>(),
                listOf<Int>()
            ),
            Arguments.of(
                listOf(listOf<Int>()),
                listOf<Int>()
            ),
            Arguments.of(
                listOf(
                    listOf(1, 2, 3)
                ),
                listOf(1, 2, 3)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Merge K Sorted lists using min heap`(input: List<List<Int>>, expected: List<Int>) {
        val actual = mergeKLists(input)
        assertContentEquals(expected, actual)
    }
}
