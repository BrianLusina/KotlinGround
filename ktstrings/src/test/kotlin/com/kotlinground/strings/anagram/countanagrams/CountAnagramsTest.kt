package com.kotlinground.strings.anagram.countanagrams

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CountAnagramsTest {
    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of("too hot", 18),
            Arguments.of("aa", 1),
            Arguments.of("all good", 36),
            Arguments.of("a a a b b", 1),
            Arguments.of("hello world", 7200),
            Arguments.of("excel", 60),
            Arguments.of("ab ab cd cd ef ef", 64)
        )
    }

    @ParameterizedTest(name = "{index} => countAnagrams({0}) should return {1}")
    @MethodSource("testCases")
    fun countAnagrams(s: String, expected: Int) {
        val actual = countAnagrams(s)
        Assertions.assertEquals(expected, actual)
    }
}
