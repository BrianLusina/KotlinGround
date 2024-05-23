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

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        other as CircularLinkedListNode<*>

        return this.key == other.key || this.data == other.data
    }

    override fun hashCode(): Int {
        var result = data?.hashCode() ?: 0
        result = 31 * result + (key?.hashCode() ?: 0)
        return result
    }
}
