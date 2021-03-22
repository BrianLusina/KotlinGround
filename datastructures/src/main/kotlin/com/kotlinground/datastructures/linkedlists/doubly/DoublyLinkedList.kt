package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.DoublyLinkedListNode
import com.kotlinground.datastructures.linkedlists.LinkedList

class DoublyLinkedList(private val head: DoublyLinkedListNode? = null) :
    LinkedList<DoublyLinkedListNode>() {

    override fun push(data: Any) {

    }

    override fun count(data: Any): Int {
        TODO("Not yet implemented")
    }

    override fun getLast(): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun search(node: DoublyLinkedListNode): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun deleteFirst(): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun removeLast(): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return head != null
    }

    override fun detectNodeWithCycle(): DoublyLinkedListNode? {
        if (head?.next == null) {
            return null
        }

        var fastPointer = head
        var slowPointer = head

        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next?.next
            slowPointer = slowPointer?.next

            if (slowPointer == fastPointer) {
                break
            }
        }

        if (fastPointer?.next == null) {
            return null
        }

        var current = head

        while (current != slowPointer) {
            current = current?.next
            slowPointer = slowPointer?.next
        }

        return current
    }

    override fun hasCycle(): Boolean {
        TODO("Not yet implemented")
    }

    override fun reverse(): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun insert(node: DoublyLinkedListNode, position: Int): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun insertAfter(
        nodeToInsert: DoublyLinkedListNode,
        currentNode: DoublyLinkedListNode
    ): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun removeCycle(): DoublyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun alternateSplit(): Pair<DoublyLinkedListNode, DoublyLinkedListNode> {
        TODO("Not yet implemented")
    }
}