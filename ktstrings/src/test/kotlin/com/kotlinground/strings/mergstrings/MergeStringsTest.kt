package com.kotlinground.strings.mergstrings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MergeStringsTest {

    @Test
    fun `should return apbqcr for word1=abc and word2=pqr`() {
        val word1 = "abc"
        val word2 = "pqr"
        val expected = "apbqcr"
        val actual = mergeAlternately(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return apbqrs for word1=ab and word2=pqrs`() {
        val word1 = "ab"
        val word2 = "pqrs"
        val expected = "apbqrs"
        val actual = mergeAlternately(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return apbqcd for word1=abcd and word2=pq`() {
        val word1 = "abcd"
        val word2 = "pq"
        val expected = "apbqcd"
        val actual = mergeAlternately(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return cefee for word1=cf and word2=eee`() {
        val word1 = "cf"
        val word2 = "eee"
        val expected = "cefee"
        val actual = mergeAlternately(word1, word2)

        assertEquals(expected, actual)
    }
}

class MergeStrings2Test {

    @Test
    fun `should return apbqcr for word1=abc and word2=pqr`() {
        val word1 = "abc"
        val word2 = "pqr"
        val expected = "apbqcr"
        val actual = mergeAlternately2(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return apbqrs for word1=ab and word2=pqrs`() {
        val word1 = "ab"
        val word2 = "pqrs"
        val expected = "apbqrs"
        val actual = mergeAlternately2(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return apbqcd for word1=abcd and word2=pq`() {
        val word1 = "abcd"
        val word2 = "pq"
        val expected = "apbqcd"
        val actual = mergeAlternately2(word1, word2)

        assertEquals(expected, actual)
    }

    @Test
    fun `should return cefee for word1=cf and word2=eee`() {
        val word1 = "cf"
        val word2 = "eee"
        val expected = "cefee"
        val actual = mergeAlternately2(word1, word2)

        assertEquals(expected, actual)
    }
}
