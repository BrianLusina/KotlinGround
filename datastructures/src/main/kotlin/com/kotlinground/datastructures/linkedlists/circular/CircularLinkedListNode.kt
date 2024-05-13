package com.kotlinground.datastructures.linkedlists.circular

import com.kotlinground.datastructures.linkedlists.LinkedListNode

/**
 * Representation of a CircularLinkedList Node
 */
data class CircularLinkedListNode<T>(
    override var data: T,
    override var next: CircularLinkedListNode<T>? = null
) : LinkedListNode<T> {
    override fun toString(): String {
        return "CircularLinkedListNode(data=$data)"
    }
}
