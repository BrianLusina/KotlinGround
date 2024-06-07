package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.LinkedList
import com.kotlinground.datastructures.linkedlists.singly.SinglyLinkedListNode

class DoublyLinkedList<T>(private var head: DoublyLinkedListNode<T>? = null) :
    LinkedList<DoublyLinkedListNode<T>, T>() {
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
        if (head == null || head?.next == null) {
            return
        }

        var current = head
        var previous: DoublyLinkedListNode<T>? = null

        while (current != null) {
            // copy a pointer to the next element, before we overwrite the current
            val next = current.next

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

    override fun deleteFirst(): DoublyLinkedListNode<T>? {
        val current = head
        if (current != null) {
            if (current.next != null) {
                current.next?.previous = null
                head = current.next
                return current
            }
            // head not is the only node, so, we set it to null and return the deleted node
            head = null
            return current
        }
        return null
    }

    override fun deleteNode(node: DoublyLinkedListNode<T>) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeAtPosition(position: Int): DoublyLinkedListNode<T>? {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByKey(key: String) {
        // no head node, means nothing further to do
        if (head == null) {
            return
        }

        // no next node, means we check if the head node is the node we seek. If this condition evaluates to true, we
        // set the head node to null and return
        if (head?.next == null && head?.key == key) {
            head = null
            return
        }

        // otherwise, the node we seek is somewhere down the list, so, we set a pointer called current at the head node
        // and use it to track which position we are in, in the doubly linked list as we traverse seeking a node with
        // the same key

        var current = head

        // we move the pointer down the Doubly Linked List until we find the Node whose key matches
        while (current != null && current.key != key) {
            current = current.next
        }

        //if there is no node that matches the condition above, we exit
        if (current == null) {
            return
        }

        // re-assign the pointers of the nodes around the node to delete. That is, moving the previous node's next
        // pointer to the current node's next pointer. This essentially 'deletes' the node by the data attribute
        val previous = current.previous
        previous?.next = current.next
        if (current.next != null) {
            current.next?.previous = previous
        }
        current = null
        return
    }

    override fun deleteNodesByKey(key: String): Collection<DoublyLinkedListNode<T>> {
        val deletedNodes = arrayListOf<DoublyLinkedListNode<T>>()

        if (head == null) {
            return emptyList()
        }

        var current = head
        while (current != null) {
            if (current.key == key) {
                deleteNodeByKey(key)
                deletedNodes.add(current)
            }
            current = current.next
        }

        return deletedNodes
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
        if (head == null || head?.next == null) {
            return head
        }

        val seen = hashMapOf<String, Boolean>()
        var current = head

        while (current != null) {
            if (!seen.containsKey(current.key)) {
                seen[current.key] = true
                current = current.next
            } else {
                val next = current.next
                val previous = current.previous
                previous?.next = next
                if (next != null) {
                    next.previous = previous
                }
                current = next
            }
        }

        return head
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