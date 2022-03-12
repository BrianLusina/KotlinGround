package com.kotlinground.datastructures.linkedlists.singly

import com.kotlinground.datastructures.linkedlists.LinkedListNode

/**
 * Representation of a SinglyLinkedList Node
 */
data class SinglyLinkedListNode<T>(
    override var data: T,
    var next: SinglyLinkedListNode<T>? = null
) : LinkedListNode<T>
