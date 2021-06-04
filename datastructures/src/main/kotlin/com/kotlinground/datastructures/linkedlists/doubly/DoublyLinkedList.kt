package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.DoublyLinkedListNode
import com.kotlinground.datastructures.linkedlists.LinkedList

class DoublyLinkedList(private var head: DoublyLinkedListNode? = null) :
    LinkedList<DoublyLinkedListNode>() {

    override fun append(data: Any) {

    }

    override fun prepend(data: Any) {
        TODO("Not yet implemented")
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

    override fun reverse() {
        if (head?.next == null) {
            return
        }

        var current = head
        var previous: DoublyLinkedListNode? = null
        var next: DoublyLinkedListNode?

        while (current != null) {
            // copy a pointer to the next element, before we overwrite the current
            next = current.next

            // reverse the next pointer & previous pointer
            current.next = previous
            current.prev = next

            // step forward in the list
            previous = current
            current = next
        }

        head = previous
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

    override fun pairwiseSwap(): DoublyLinkedListNode? {
        TODO("Not yet implemented")
    }

    override fun swapNodesAtKthAndKPlusOne(k: Int): DoublyLinkedListNode? {
        TODO("Not yet implemented")
    }

    override fun deleteNode(node: DoublyLinkedListNode) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeAtPosition(position: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByData(data: Any) {
        TODO("Not yet implemented")
    }

    override fun deleteNodesByData(data: Any): DoublyLinkedListNode? {
        TODO("Not yet implemented")
    }

    override fun swapNodes(dataOne: Any, dataTwo: Any) {
        if (head == null) {
            throw Exception("Empty LinkedList")
        }

        if (dataOne == dataTwo) {
            return
        }

        var currentOne = head
        var currentTwo = head

        while (currentOne != null && currentOne.data != dataOne) {
            currentOne = currentOne.next
        }

        while (currentTwo != null && currentTwo.data != dataTwo) {
            currentTwo = currentTwo.next
        }

        if (currentOne == null || currentTwo == null) {
            return
        }

        val tempOne = currentOne.data
        val tempTwo = currentTwo.data

        currentOne.data = tempOne
        currentTwo.data = tempTwo
    }
}