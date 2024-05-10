package com.kotlinground.datastructures.linkedlists.singly

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class UtilsTest {
    @Test
    fun `mergeTwoSortedLists should return (1,2,3,4,5,6,7,8) from l1=(1,5,6,8) and l2=(2,3,4,7)`() {
        val l1 = intArrayOf(1, 5, 6, 8)
        val linkedListOne = SinglyLinkedList<Int>()
        for (data in l1) {
            linkedListOne.append(data)
        }

        val l2 = intArrayOf(2, 3, 4, 7)
        val linkedListTwo = SinglyLinkedList<Int>()
        for (data in l2) {
            linkedListTwo.append(data)
        }

        val actual = mergeTwoSortedLists(linkedListOne.headNode(), linkedListTwo.headNode())
        assertNotNull(actual)

        var actualHead = actual
        val actualData = arrayListOf<Int>()
        while (actualHead != null) {
            actualData.add(actualHead.data)
            actualHead = actualHead.next
        }

        val expected = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertContentEquals(expected, actualData)
    }

    @Test
    fun `mergeTwoSortedLists should return (1,2,3,4,5,6,7,8) from l1=(0,5,6,8) and l2=(2,3,4,7) and l3=(1,9,10)`() {
        val l1 = intArrayOf(0, 5, 6, 8)
        val linkedListOne = SinglyLinkedList<Int>()
        for (data in l1) {
            linkedListOne.append(data)
        }

        val l2 = intArrayOf(2, 3, 4, 7)
        val linkedListTwo = SinglyLinkedList<Int>()
        for (data in l2) {
            linkedListTwo.append(data)
        }

        val l3 = intArrayOf(1, 9, 10)
        val linkedListThree = SinglyLinkedList<Int>()
        for (data in l3) {
            linkedListThree.append(data)
        }

        val linkedLists = arrayListOf(linkedListOne.headNode(), linkedListTwo.headNode(), linkedListThree.headNode())
        val actual = mergeKLists(linkedLists)
        assertNotNull(actual)

        var actualHead = actual
        val actualData = arrayListOf<Int>()
        while (actualHead != null) {
            actualData.add(actualHead.data)
            actualHead = actualHead.next
        }

        val expected = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertContentEquals(expected, actualData)
    }
}