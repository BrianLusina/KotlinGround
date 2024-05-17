package com.kotlinground.datastructures.linkedlists.circular

import com.kotlinground.datastructures.linkedlists.LinkedListNode
import java.security.MessageDigest

/**
 * Representation of a CircularLinkedList Node
 */
data class CircularLinkedListNode<T>(
    override var data: T,
    override var next: CircularLinkedListNode<T>? = null,
    override val key: String? = lazy {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(data.toString().toByteArray())
        digest.toString()
    }.toString()
) : LinkedListNode<T> {
    override fun toString(): String {
        return "CircularLinkedListNode(data=$data, key=$key)"
    }
}
