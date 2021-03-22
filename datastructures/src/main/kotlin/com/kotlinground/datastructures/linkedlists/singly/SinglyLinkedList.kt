package com.kotlinground.datastructures.linkedlists.singly

import com.kotlinground.datastructures.linkedlists.LinkedList
import com.kotlinground.datastructures.linkedlists.SinglyLinkedListNode
import java.lang.IllegalArgumentException

class SinglyLinkedList(private val head: SinglyLinkedListNode? = null) :
    LinkedList<SinglyLinkedListNode>() {

    override fun push(data: Any) {

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
}