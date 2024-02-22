package com.kotlinground.datastructures.randomizedset

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class RandomizedSetTest {
    @Test
    fun `test steps insert(1) - remove(2) - insert(2) - get_random() - remove(1) - insert(2) - get_random()`() {
        val randomizedSet = RandomizedSet<Int>()

        // Inserts 1 to the set. Returns true as 1 was inserted successfully
        val actualStep1 = randomizedSet.insert(1)
        assertTrue(actualStep1)

        // Returns false as 2 does not exist in the set.
        val actualStep2 = randomizedSet.remove(2)
        assertFalse(actualStep2)

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        val actualStep3 = randomizedSet.insert(2)
        assertTrue(actualStep3)

        // getRandom() should return either 1 or 2 randomly.
        val actualStep4 = randomizedSet.getRandom()
        assertContains(intArrayOf(1, 2), actualStep4)

        // Removes 1 from the set, returns true. Set now contains [2].
        val actualStep5 = randomizedSet.remove(1)
        assertTrue(actualStep5)

        // 2 was already in the set, so return false.
        val actualStep6 = randomizedSet.insert(2)
        assertFalse(actualStep6)

        // Since 2 is the only number in the set, getRandom() will always return 2.
        val actualStep7 = randomizedSet.getRandom()
        val expected = 2
        assertEquals(expected, actualStep7)
    }

    @Test
    fun `test steps remove(0) - remove(0) - insert(0) - getRandom() - remove(0) - insert(0)`() {
        val randomizedSet = RandomizedSet<Int>()

        // Remove 0 from the set. Returns false as 0 is not in the set
        val actualStep1 = randomizedSet.remove(0)
        assertFalse(actualStep1)

        // Returns false as 0 does not exist in the set.
        val actualStep2 = randomizedSet.remove(0)
        assertFalse(actualStep2)

        // Inserts 0 to the set, returns true. Set now contains [0].
        val actualStep3 = randomizedSet.insert(0)
        assertTrue(actualStep3)

        // getRandom() should return 0.
        val actualStep4 = randomizedSet.getRandom()
        assertContains(intArrayOf(0), actualStep4)

        // Removes 0 from the set, returns true. Set now is [].
        val actualStep5 = randomizedSet.remove(0)
        assertTrue(actualStep5)

        // insert 0 to return true
        val actualStep6 = randomizedSet.insert(0)
        assertTrue(actualStep6)
    }

    @Test
    fun `test steps insert(3) - insert(3) - getRandom() - getRandom() - insert(1) - remove(3) - getRandom() - getRandom() - insert(0) - remove(0)`() {
        val randomizedSet = RandomizedSet<Int>()

        // Insert 3 in the set. Returns true as 3 is now added to the set
        val actualStep1 = randomizedSet.insert(3)
        assertTrue(actualStep1)

        // Insert 3 in the set should return false as 3 is already in the set
        val actualStep2 = randomizedSet.insert(3)
        assertFalse(actualStep2)

        // Returns 3 as 3 is the only item in the set
        val actualStep3 = randomizedSet.getRandom()
        assertContains(intArrayOf(3), actualStep3)

        // Returns 3 as 3 is the only item in the set
        val actualStep4 = randomizedSet.getRandom()
        assertContains(intArrayOf(3), actualStep4)

        // Inserts 1 to the set, returns true. Set now contains [3, 1].
        val actualStep5 = randomizedSet.insert(1)
        assertTrue(actualStep5)

        // remove 3 from the set and return true, set should now be [1]
        val actualStep6 = randomizedSet.remove(3)
        assertTrue(actualStep6)

        // should return 1, as it's the only value in the set
        val actualStep7 = randomizedSet.getRandom()
        assertEquals(1, actualStep7)

        // should return 1, as it's the only value in the set
        val actualStep8 = randomizedSet.getRandom()
        assertEquals(1, actualStep8)

        // insert 0 to return true
        val actualStep9 = randomizedSet.insert(0)
        assertTrue(actualStep9)

        // remove 0 to return true
        val actualStep10 = randomizedSet.remove(0)
        assertTrue(actualStep10)
    }
}
