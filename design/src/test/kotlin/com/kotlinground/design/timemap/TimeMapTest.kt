package com.kotlinground.design.timemap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TimeMapTest {
    @Test
    fun `set('foo', 'bar', 1) - get('foo', 1) - get('foo', 3) - get('foo', 3) - set('foo', 'bar2', 4) - get('foo', 4) - get('foo', 5`() {
        val timeMap = TimeMap()

        // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.set("foo", "bar", 1)

        // return "bar"
        val expectedBar = "bar"
        val actualAtTime1 = timeMap.get("foo", 1)
        assertEquals(expectedBar, actualAtTime1)

        // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value
        // is at timestamp 1 is "bar".
        val expectedBar2 = "bar"
        val actualAtTime3 = timeMap.get("foo", 3)
        assertEquals(expectedBar2, actualAtTime3)

        // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.set("foo", "bar2", 4)

        // return "bar2"
        val expectedBar22 = "bar2"
        val actualAtTime4 = timeMap.get("foo", 4)
        assertEquals(expectedBar22, actualAtTime4)

        // return "bar2"
        val expectedBar23 = "bar2"
        val actualAtTime5 = timeMap.get("foo", 5)
        assertEquals(expectedBar23, actualAtTime5)
    }
}
