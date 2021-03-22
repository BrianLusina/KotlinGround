package com.kotlinground.datastructures.linkedlists

/**
 * LinkedListNode representation
 */
sealed class LinkedListNode

/**
 * Representation of a SinglyLinkedList Node
 */
data class SinglyLinkedListNode(
    var data: Any,
    var next: SinglyLinkedListNode? = null
) : LinkedListNode()

/**
 * Representation of a DoublyLinkedList Node
 */
data class DoublyLinkedListNode(
    var data: Any,
    var next: DoublyLinkedListNode? = null,
    var prev: DoublyLinkedListNode? = null
) : LinkedListNode()
