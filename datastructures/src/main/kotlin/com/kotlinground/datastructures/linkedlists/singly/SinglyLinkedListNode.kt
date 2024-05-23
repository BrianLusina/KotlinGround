package com.kotlinground.datastructures.linkedlists.singly

import com.kotlinground.datastructures.linkedlists.LinkedListNode
import java.security.MessageDigest

/**
 * Representation of a SinglyLinkedList Node
 */
data class SinglyLinkedListNode<T>(
    override var data: T,
    override var next: SinglyLinkedListNode<T>? = null,
    override val key: String? = lazy {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(data.toString().toByteArray())
        digest.toString()
    }.toString()
) : LinkedListNode<T>
