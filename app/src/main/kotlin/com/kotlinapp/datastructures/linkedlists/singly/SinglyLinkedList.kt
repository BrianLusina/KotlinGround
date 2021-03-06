package com.kotlinapp.datastructures.linkedlists.singly

import com.kotlinapp.datastructures.linkedlists.LinkedList
import com.kotlinapp.datastructures.linkedlists.SinglyLinkedListNode

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

    override fun detectNodeWithCycle(head: SinglyLinkedListNode?): SinglyLinkedListNode? {
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

    override fun hasCycle(head: SinglyLinkedListNode): Boolean {
        TODO("Not yet implemented")
    }

    override fun reverse(head: SinglyLinkedListNode): SinglyLinkedListNode {
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

    override fun removeCycle(head: SinglyLinkedListNode): SinglyLinkedListNode {
        TODO("Not yet implemented")
    }
}