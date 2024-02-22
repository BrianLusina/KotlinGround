package com.kotlinground.datastructures.smallestinfiniteset

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SmallestInfiniteSetTest {
    @Test
    fun `add_back(2) - pop_smallest() - pop_smallest() - pop_smallest() - add_back(1) - pop_smallest() - pop_smallest() - pop_smallest()`(){
        val smallestInfiniteSet = SmallestInfiniteSet()

        // 2 is already in the set, so no change is made.
        smallestInfiniteSet.addBack(2)

        // return 1, since 1 is the smallest number, and remove it from the set.
        val actual1 = smallestInfiniteSet.popSmallest()
        val expected1 = 1
        assertEquals(expected1, actual1)

        // return 2, and remove it from the set.
        val actual2 = smallestInfiniteSet.popSmallest()
        val expected2 = 2
        assertEquals(expected2, actual2)

        // return 3, and remove it from the set.
        val actual3 = smallestInfiniteSet.popSmallest()
        val expected3 = 3
        assertEquals(expected3, actual3)

        // 1 is added back to set
        smallestInfiniteSet.addBack(1)

        // return 1, since 1 was added back to the set and is the smallest number, and remove it from the set.
        val actual1Again = smallestInfiniteSet.popSmallest()
        val expected1Again = 1
        assertEquals(expected1Again, actual1Again)

        // return 4, and remove it from the set.
        smallestInfiniteSet.popSmallest()
    }

    @Test
    fun `popSmallest() is called 1000 times`() {
        val smallestInfiniteSet = SmallestInfiniteSet()

        for (x in 1 until 1001) {
            val actual = smallestInfiniteSet.popSmallest()
            assertEquals(x, actual)
        }
    }
}
