package com.kotlinground.algorithms.slidingwindow.repeateddnasequences

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class FindRepeatedDnaSequencesTest {

    companion object {
        @JvmStatic
        fun cases() = listOf(
            Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", listOf("AAAAACCCCC", "CCCCCAAAAA")),
            Arguments.of("AAAAAAAAAAAAA", listOf("AAAAAAAAAA")),
            Arguments.of("GGGGGGGGGGGGGGGGGGGG", listOf("GGGGGGGGGG")),
            Arguments.of("TTTGGGAAATTTGGGAAACC", listOf<String>()),
            Arguments.of("ACGTACGTACGTACGTACGTACGTACGTACGT", listOf("ACGTACGTAC", "CGTACGTACG", "GTACGTACGT", "TACGTACGTA")),
            Arguments.of("GTACGTACGTACGCCCCCCCCGGGGG", listOf<String>()),
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun findRepeatedDnaSequencesTest(input: String, expected: List<String>) {
        assertEquals(expected, findRepeatedDnaSequences(input))
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun findRepeatedDnaSequencesNaiveTest(input: String, expected: List<String>) {
        assertEquals(expected, findRepeatedDnaSequencesNaive(input))
    }
}
