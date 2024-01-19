package com.kotlinground.algorithms.arrays.majorityelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    @Test
    fun `should return 3 from nums=(3,2,3)`() {
        val nums = intArrayOf(3, 2, 3)
        val expected = 3
        val actual = majorityElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from nums=(2,2,1,1,1,2,2)`() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        val expected = 2
        val actual = majorityElement(nums)
        assertEquals(expected, actual)
    }
}

class MajorityElementWithHashMapTest {
    @Test
    fun `should return 3 from nums=(3,2,3)`() {
        val nums = intArrayOf(3, 2, 3)
        val expected = 3
        val actual = majorityElementWithHashMap(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from nums=(2,2,1,1,1,2,2)`() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        val expected = 2
        val actual = majorityElementWithHashMap(nums)
        assertEquals(expected, actual)
    }
}

class MajorityElementWithVotingTest {
    @Test
    fun `should return 3 from nums=(3,2,3)`() {
        val nums = intArrayOf(3, 2, 3)
        val expected = 3
        val actual = majorityElementWithVoting(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 2 from nums=(2,2,1,1,1,2,2)`() {
        val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        val expected = 2
        val actual = majorityElementWithVoting(nums)
        assertEquals(expected, actual)
    }
}
