package com.kotlinground.datastructures.hashset

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
class MyHashSetTest {
    private val myHashSet = MyHashSet()

    @Test
    fun `Should add 1 to hashset`() {
        val n = 1
        myHashSet.add(n)

        Assertions.assertEquals(hashSetOf(1), myHashSet.hash)
    }
}
