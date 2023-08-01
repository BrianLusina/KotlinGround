package com.kotlinground.puzzles.queue.recentcounter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RecentCounterTest {
    @Test
    fun `test 3 calls`() {
        val recentCounter = RecentCounter()

        val actualPing1 = recentCounter.ping(1)
        assertEquals(actualPing1, 1)

        val actualPing100 = recentCounter.ping(100)
        assertEquals(actualPing100, 2)

        val actualPing3001 = recentCounter.ping(3001)
        assertEquals(actualPing3001, 3)

        val actualPing3002 = recentCounter.ping(3002)
        assertEquals(actualPing3002, 3)
    }
}
