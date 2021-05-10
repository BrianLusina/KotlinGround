package com.kotlinground.datastructures.linkedlists.singly

import com.kotlinground.datastructures.linkedlists.LinkedList
import com.kotlinground.datastructures.linkedlists.SinglyLinkedListNode
import java.lang.IllegalArgumentException

class SinglyLinkedList(private val head: SinglyLinkedListNode? = null) :
    LinkedList<SinglyLinkedListNode>() {

    override fun append(data: Any) {

    }

    override fun prepend(data: Any) {
        TODO("Not yet implemented")
    }

    override fun count(data: Any): Int {
        TODO("Not yet implemented")
    }

    override fun getLast(): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun search(node: SinglyLinkedListNode): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun deleteFirst(): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun removeLast(): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        return head != null
    }

    override fun detectNodeWithCycle(): SinglyLinkedListNode? {
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

    override fun reverse(): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun insert(node: SinglyLinkedListNode, position: Int): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun insertAfter(
        nodeToInsert: SinglyLinkedListNode,
        currentNode: SinglyLinkedListNode
    ): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun removeCycle(): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }

    override fun alternateSplit(): Pair<SinglyLinkedListNode, SinglyLinkedListNode> {
        if (head == null) {
            throw IllegalArgumentException("Cannot split linked list with no head")
        }
        if (head.next == null) {
            throw IllegalArgumentException("Cannot split linked list with only 1 node")
        }

        var current = head
        val first = current
        val second = current.next

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

        return Pair(first, second!!)
    }

    override fun pairwiseSwap(): SinglyLinkedListNode? {
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
    override fun swapNodesAtKthAndKPlusOne(k: Int): SinglyLinkedListNode? {
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

    override fun deleteNode(node: SinglyLinkedListNode) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeAtPosition(position: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteNodeByData(data: Any) {
        TODO("Not yet implemented")
    }
}