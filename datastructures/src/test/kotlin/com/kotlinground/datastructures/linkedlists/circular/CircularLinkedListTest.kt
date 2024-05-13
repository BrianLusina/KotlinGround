package com.kotlinground.datastructures.linkedlists.circular

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class CircularLinkedListAppendTest {
    @Test
    fun `should append a new node 7 to linked list (1,2,3,4,5,6) to become (1,2,3,4,5,6,7)`() {
        val data = intArrayOf(1, 2, 3, 4, 5, 6)
        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7)
        val linkedList = CircularLinkedList<Int>()

        for (d in data) {
            linkedList.append(d)
        }

        linkedList.append(7)

        val actualHead = linkedList.headNode()
        assertNotNull(actualHead)

        assertEquals(1, actualHead.data)

        val actualData = arrayListOf<Int>()
        for (node in linkedList) {
            actualData.add(node.data)
        }

        assertEquals(expected, actualData)
    }
}
