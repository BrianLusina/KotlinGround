package com.kotlinground.strings.permutations

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import kotlin.test.Test

class CheckPermutationsWithSortingTest {
    @Test
    fun `should return true with input_str_1=google and input_str_2=ooggle`() {
        val inputStr1="google"
        val inputStr2="ooggle"
        assertTrue { checkPermutationWithSorting(inputStr1, inputStr2) }
    }
    @Test
    fun `should return true with input_str_1=not and input_str_2=top`() {
        val inputStr1="not"
        val inputStr2="top"
        assertFalse { checkPermutationWithSorting(inputStr1, inputStr2) }
    }
}

class CheckPermutationsWithMapTest {
    @Test
    fun `should return true with input_str_1=google and input_str_2=ooggle`() {
        val inputStr1="google"
        val inputStr2="ooggle"
        assertTrue { checkPermutationWithMap(inputStr1, inputStr2) }
    }
    @Test
    fun `should return true with input_str_1=not and input_str_2=top`() {
        val inputStr1="not"
        val inputStr2="top"
        assertFalse { checkPermutationWithMap(inputStr1, inputStr2) }
    }
}
