package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.LinkedList

class DoublyLinkedList<T> : LinkedList<DoublyLinkedListNode<T>, T>() {
    private var head: DoublyLinkedListNode<T>? = null
    private var tail: DoublyLinkedListNode<T>? = null
    public var size: Int = 0

    override fun headNode(): DoublyLinkedListNode<T>? {
        return head
    }

    override fun iterator(): Iterator<DoublyLinkedListNode<T>> {
        return DoublyLinkedListIterator(head)
    }

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
            newNode.previous = current
        }
    }

    override fun pop(): T? {
        if (head == null) {
            return null
        }

        // instances where the list is of size 1, that is has only 1 node
        if (head?.next == null) {
            val node = head
            head = null
            tail = null
            return node?.data
        }

        val lastNode = tail
        val lastNodePrev = tail?.previous
        lastNodePrev?.next = null
        tail = lastNodePrev
        return lastNode?.data

//        Below is a viable option if we are not keeping track of the tail node in the linked list. This involves
//        needing to traverse the whole linked list to reach the last node. Note that this ends up being an O(n) operation
//        var current = head
//
//        while (current?.next != null) {
//            current = current.next
//        }
//
//        //if the current node has a pointer to the previous node
//        if (current?.previous != null) {
//            // we assign the previous pointer to a 'temp' variable
//            val lastNodePrev = current.previous
//
//            // then assign the next node to None
//            lastNodePrev?.next = null
//
//            // and lastly set the new tail
//            tail = lastNodePrev
//        }
//
//        return current?.data
    }

    override fun prepend(data: T) {
        val node = DoublyLinkedListNode(data)
        if (head == null) {
            head = node
        } else {
            head?.previous = node
            node.next = head
            head = node
        }
    }

    override fun shift(): T? {
        if (head != null) {
            size--
            val currentHead = head
            val newHead = currentHead?.next

            if (newHead != null) {
                newHead.previous = null
            }

            head = newHead
            return currentHead?.data
        }
        return null
    }

    override fun countOccurrences(data: T): Int {
        if (head == null) {
            return 0
        }
        var occurrences = 0
        var current = head
        while (current != null) {
            if (current.data == data) {
                occurrences++
            }
            current = current.next
        }
        return occurrences
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
            current.previous = next

            // step forward in the list
            previous = current
            current = next
        }

        head = previous
    }

    override fun insert(node: DoublyLinkedListNode<T>, position: Int): DoublyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun insertAfter(data: T, key: Any) {
        var current = head
        while (current != null) {
            if (current.next == null && current.key == key) {
                append(data)
                return
            } else if (current.key == key) {
                val nodeToInsert = DoublyLinkedListNode(data)
                val nxt = current.next
                current.next = nodeToInsert
                nodeToInsert.next = nxt
                nodeToInsert.previous = current
                return
            }
            current = current.next
        }
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

    override fun deleteNodeAtPosition(position: Int): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByKey(key: String) {
        TODO("Not yet implemented")
    }

    override fun deleteNodesByKey(key: String): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun deleteMiddle(): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun findMiddleNode(): DoublyLinkedListNode<T>? {
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

//        currentOne.data = tempOne
//        currentTwo.data = tempTwo
    }

    override fun size(): Int {
        if (head == null) {
            return 0
        }

        var count = 0
        var current = head

        while (current != null) {
            count++
            current = current.next
        }

        return count
    }

    override fun oddEvenList(): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun removeDuplicates(): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun nthToLastNode(n: Int): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun rotate(k: Int): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun isPalindrome(): Boolean {
        TODO("Not yet implemented")
    }

    override fun moveTailToHead() {
        if (head != null && head?.next != null) {
            var last = head

            while (last?.next != null) {
                last = last.next
            }

            // we can obtain the second_to_last node from the last node
            val secondToLast = last?.previous

            // set the current head node's second_to_last pointer to the last node
            head?.previous = last

            // set the next pointer of the last node to the head node
            last?.next = head

            // remove the secondToLast pointer of the last node
            last?.previous = null

            // remove the next pointer of the secondToLast node
            secondToLast?.next = null

            // set the head node as the last node
            head = last
        }
    }
}