package com.kotlinground.algorithms.trie.indexpairs

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class IndexPairsTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(
                "thestoryofeducativeandme",
                listOf("story", "feduc", "educative"),
                listOf(
                    Pair(3, 7),
                    Pair(9, 13),
                    Pair(10, 18),
                )
            ),
            Arguments.of(
                "xyxyx",
                listOf("xyx", "xy"),
                listOf(
                    Pair(0, 1),
                    Pair(0, 2),
                    Pair(2, 3),
                    Pair(2, 4),
                )
            ),
            Arguments.of(
                "howareyou",
                listOf("how", "are", "you"),
                listOf(
                    Pair(0, 2),
                    Pair(3, 5),
                    Pair(6, 8),
                )
            ),
            Arguments.of(
                "weather",
                listOf("weather"),
                listOf(
                    Pair(0, 6),
                )
            ),
            Arguments.of(
                "aquickbrownfoxjumpsoverthelazydog",
                listOf("quick", "fox", "dog"),
                listOf(
                    Pair(1, 5),
                    Pair(11, 13),
                    Pair(30, 32),
                )
            ),
        )
    }

    @ParameterizedTest(name =  "{index} => indexPairs(\"{0}\", \"{1}\") should return {2}")
    @MethodSource("testCases")
    fun `index pairs of a string`(s: String, words: List<String>, expected: List<Pair<Int, Int>>) {
        val actual = indexPairs(s, words)
        assert(actual == expected)
    }
}
