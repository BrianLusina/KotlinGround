package com.kotlinground.algorithms.backtracking.partitionstring

import io.mockk.InternalPlatformDsl.toArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class PartitionTest {
    @Test
    fun `should return (('aa', 'b'), ('a','a','b')) from aab`() {
        val s = "aab"
        val expected = listOf(listOf("a", "a", "b"), listOf("aa", "b"))
        val actual = partition(s)
        assertContentEquals(expected, actual)
    }

    @Test
    fun `should return (('aba'), ('a','b','a')) from aba`() {
        val s = "aba"
        val expected = listOf(listOf("a", "b", "a"), listOf("aba"))
        val actual = partition(s)
        assertContentEquals(expected, actual)
    }
}
