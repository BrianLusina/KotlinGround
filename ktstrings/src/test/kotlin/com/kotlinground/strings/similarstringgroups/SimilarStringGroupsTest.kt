package com.kotlinground.strings.similarstringgroups

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class SimilarStringGroupsTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(listOf<String>(), 0),
            Arguments.of(listOf("jhki", "kijh", "jkhi", "kihj", "ijhk"), 3),
            Arguments.of(listOf("abc", "acb", "bac", "bca", "cab", "cba"), 1),
            Arguments.of(listOf("abcd", "abdc", "acbd", "bdca"), 2),
            Arguments.of(listOf("fgtdvepeqcfajhlzkwlpuhrwfcueqfbs",
                "fgcdvppeqcfajhlzkwluehrwftuefqbs",
                "fgtdvepeqcfajhlzkwlpuhrwfcuefqbs",
                "fgcdvepeqcfajhlzkwluphrwftuefqbs",
                "fgldvepeqcfajhlzkwcuphrwftuefqbs",
                "fgtdvefeqcpajhlzkwlpuhrwfcuefqbs",), 2),
        )
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `number of similar string groups`(input: List<String>, expected: Int) {
        val actual = numOfSimilarGroups(input)
        assertEquals(expected, actual)
    }
}
