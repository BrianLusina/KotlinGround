package com.kotlinground.algorithms.arrays.removeelement

import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveelementKtTest {

    @Test
    fun `Should return 2 for nums = 3,2,2,3 and val = 3`() {
        val nums = intArrayOf(3, 2, 2, 3)
        val n = 3
        val actual = removeElement(nums, n)
        val expected = 2
        assertEquals(expected, actual)
    }
}
