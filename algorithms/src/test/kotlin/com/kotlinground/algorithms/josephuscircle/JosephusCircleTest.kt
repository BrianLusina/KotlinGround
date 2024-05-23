package com.kotlinground.algorithms.josephuscircle

import com.kotlinground.datastructures.linkedlists.circular.CircularLinkedList
import com.kotlinground.datastructures.linkedlists.circular.CircularLinkedListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JosephusCircleTest {

    @Test
    fun `should run through the circle of 1-2-3-4 with a step of 2 remaining with 1`() {
        val data = arrayListOf(1, 2, 3, 4)
        val circularLinkedList = CircularLinkedList<Int>()
        for (d in data) {
            circularLinkedList.append(d)
        }

        val step = 2
        val expected = CircularLinkedListNode(1)
        val actual = josephusCircle(circularLinkedList, step)
        assertEquals(expected, actual)
    }
}
