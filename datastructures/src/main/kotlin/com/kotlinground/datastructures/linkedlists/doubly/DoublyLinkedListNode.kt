package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.LinkedListNode

/**
 * Representation of a DoublyLinkedList Node
 */
data class DoublyLinkedListNode<T>(
    override val data: T,
    var next: DoublyLinkedListNode<T>? = null,
    var previous: DoublyLinkedListNode<T>? = null
) : LinkedListNode<T>
