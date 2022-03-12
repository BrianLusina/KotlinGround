package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.LinkedList

class DoublyLinkedList<T>(private var head: DoublyLinkedListNode<T>? = null) : LinkedList<DoublyLinkedListNode<T>, T> {

    override fun append(data: T) {
        val newNode = DoublyLinkedListNode(data)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
            newNode.prev = current
        }
    }

    override fun pop(): T? {
        if (head == null) {
            return null
        }

        var current = head

        while (current?.next != null) {
            current = current.next
        }

        val prevNode = current?.prev
        prevNode?.next = null
        current?.prev = null

        return current?.data
    }

    override fun prepend(data: T) {
        if (head == null) {
            head = DoublyLinkedListNode(data)
        } else {
            val newHead = DoublyLinkedListNode(data)
            newHead.next = head
            head?.prev = newHead
            head = newHead
        }
    }

    override fun shift(): T? {
        if (head != null) {
            val currentHead = head
            head = currentHead?.next
            currentHead?.next = null
            return currentHead?.data
        }
        return null
    }

    override fun count(data: T): Int {
        TODO("Not yet implemented")
    }

    override fun getLast(): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun search(node: DoublyLinkedListNode<T>): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun deleteFirst(): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun removeLast(): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return head != null
    }

    override fun detectNodeWithCycle(): DoublyLinkedListNode<T>? {
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
        var previous: DoublyLinkedListNode<T>? = null
        var next: DoublyLinkedListNode<T>?

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

    override fun insert(node: DoublyLinkedListNode<T>, position: Int): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun insertAfter(
        nodeToInsert: DoublyLinkedListNode<T>,
        currentNode: DoublyLinkedListNode<T>
    ): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun removeCycle(): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun alternateSplit(): Pair<DoublyLinkedListNode<T>, DoublyLinkedListNode<T>> {
        TODO("Not yet implemented")
    }

    override fun pairwiseSwap(): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun swapNodesAtKthAndKPlusOne(k: Int): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun deleteNode(node: DoublyLinkedListNode<T>) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeAtPosition(position: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByData(data: T) {
        TODO("Not yet implemented")
    }

    override fun deleteNodesByData(data: T): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun swapNodes(dataOne: T, dataTwo: T) {
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