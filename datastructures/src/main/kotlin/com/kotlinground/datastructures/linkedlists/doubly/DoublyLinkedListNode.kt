package com.kotlinground.datastructures.linkedlists.doubly

import com.kotlinground.datastructures.linkedlists.LinkedListNode
import java.security.MessageDigest

/**
 * Representation of a DoublyLinkedList Node
 */
data class DoublyLinkedListNode<T>(
    override val data: T,
    override var next: DoublyLinkedListNode<T>? = null,
    var previous: DoublyLinkedListNode<T>? = null,
    override val key: String = lazy {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(data.toString().toByteArray())
        digest.toString()
    }.toString()
) : LinkedListNode<T>

