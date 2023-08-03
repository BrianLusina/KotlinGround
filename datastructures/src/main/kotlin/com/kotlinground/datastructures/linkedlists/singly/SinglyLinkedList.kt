package com.kotlinground.datastructures.linkedlists.singly

import com.kotlinground.datastructures.linkedlists.LinkedList

class SinglyLinkedList<T>(private var head: SinglyLinkedListNode<T>? = null) : LinkedList<SinglyLinkedListNode<T>, T> {

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

    override fun headNode(): SinglyLinkedListNode<T>? {
        return head
    }

    override fun append(data: T) {

    }

    override fun prepend(data: T) {
        TODO("Not yet implemented")
    }

    override fun count(data: T): Int {
        TODO("Not yet implemented")
    }

    override fun getLast(): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun search(node: SinglyLinkedListNode<T>): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun deleteFirst(): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun removeLast(): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return head != null
    }

    override fun detectNodeWithCycle(): SinglyLinkedListNode<T>? {
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
        var previous: SinglyLinkedListNode<T>? = null
        var next: SinglyLinkedListNode<T>?

        while (current != null) {
            next = current.next
            current.next = previous
            previous = current
            current = next
        }

        head = previous
    }

    override fun insert(node: SinglyLinkedListNode<T>, position: Int): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun insertAfter(
        nodeToInsert: SinglyLinkedListNode<T>,
        currentNode: SinglyLinkedListNode<T>
    ): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun removeCycle(): SinglyLinkedListNode<T> {
        TODO("Not yet implemented")
    }

    override fun alternateSplit(): Pair<SinglyLinkedListNode<T>, SinglyLinkedListNode<T>> {
        if (head == null) {
            throw IllegalArgumentException("Cannot split linked list with no head")
        }
        if (head!!.next == null) {
            throw IllegalArgumentException("Cannot split linked list with only 1 node")
        }

        var current = head
        val first = current
        val second = current?.next

        while (current?.next != null) {
            val temp = current.next
            if (temp != null) {
                current.next = temp.next
            }

            if (current.next != null && current.next!!.next != null) {
                if (temp != null) {
                    temp.next = current.next!!.next
                }
            } else {
                if (temp != null) {
                    temp.next = null
                }
            }

            current = current.next
        }

        return Pair(first!!, second!!)
    }

    override fun pairwiseSwap(): SinglyLinkedListNode<T>? {
        // if the head is null, nothing to do here
        if (head == null) {
            return head
        }

        var current = head

        // Only traverse as long as we have 2 nodes left
        while (current?.next != null) {
            // if the data in the pair of nodes is the same
            if (current.data == current.next?.data) {
                // move on to the next pair
                current = current.next?.next
            } else {
                // swap the data
                val temp = current.data
                current.data = current.next!!.data
                current.next?.data = temp

                // move to the next pair
                current = current.next?.next
            }
        }

        return head
    }

    // TODO: swap nodes in place
    override fun swapNodesAtKthAndKPlusOne(k: Int): SinglyLinkedListNode<T>? {
        val current = head
        var a = current
        var b = current

        for (next in 1..k) {
            a = a?.next
        }

        val node = a
        a = a?.next

        while (a != null) {
            a = a.next
            b = b?.next
        }

        val temp = node?.data
        node?.data = b!!.data
        b.data = temp!!

        return head
    }

    override fun deleteNode(node: SinglyLinkedListNode<T>) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeAtPosition(position: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByData(data: T) {
        TODO("Not yet implemented")
    }

    override fun deleteNodesByData(data: T): SinglyLinkedListNode<T>? {
        if (head != null) {
            val dummyHead = SinglyLinkedListNode(data = head!!.data, next = head)
            var current = dummyHead

            while (current.next != null) {
                if (current.next!!.data === data) {
                    current.next = current.next!!.next;
                } else {
                    current = current.next!!
                }
            }

            return dummyHead.next
        }
        return null
    }

    override fun deleteMiddle(): SinglyLinkedListNode<T>? {
        if (head == null || head?.next == null) {
            return null
        }

        val nodeCount = size()
        val middleIndex = nodeCount / 2

        var current = head

        for (x in 0 until middleIndex - 1) {
            current = current?.next
        }

        val middleNode = current?.next

        current?.next = current?.next?.next

        return middleNode
    }

    fun deleteMiddle2Pointers(): SinglyLinkedListNode<T>? {
        if (head == null || head?.next == null) {
            return null
        }

        var slowPointer = head
        var fastPointer = head?.next?.next

        while (fastPointer?.next != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }

        val middleNode = slowPointer?.next

        slowPointer?.next = slowPointer?.next?.next

        return middleNode
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


    override fun pop(): T? {
        TODO("Not yet implemented")
    }

    override fun shift(): T? {
        TODO("Not yet implemented")
    }
}