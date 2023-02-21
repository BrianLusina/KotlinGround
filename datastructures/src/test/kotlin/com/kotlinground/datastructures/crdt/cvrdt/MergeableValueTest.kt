package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.datetime.Clock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MergeableValueTest {
    @Test
    fun `equal timestamps should return same data types for 2 different mergeable values`() {
        val timestamp = Clock.System.now()
        val a = MergeableValue(1, timestamp)
        val b = MergeableValue(2, timestamp)

        val c1 = a.merge(b)
        val c2 = b.merge(a)
        assertEquals(c1, c2)
    }
}
