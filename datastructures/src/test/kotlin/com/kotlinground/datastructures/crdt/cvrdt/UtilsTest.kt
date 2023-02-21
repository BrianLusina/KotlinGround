package com.kotlinground.datastructures.crdt.cvrdt

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.Thread.sleep

class UtilsTest {

    @Test
    fun equalsTest() {
        val a = mergeableValueOf(1)
        sleep(1)
        val b = mergeableValueOf(1)
        assertEquals(a, b)

        val c = mergeableValueOf(2)
        assertNotEquals(a, c)
    }

    @Test
    fun fuzz() {
        val values = (0 until 1000).map { mergeableValueOf(it) }
        val mergedA = values.shuffled().reduce { a, b -> a.merge(b) }
        val mergedB = values.shuffled().reduce { a, b -> a.merge(b) }
        assertEquals(mergedA, mergedB)
    }
}
