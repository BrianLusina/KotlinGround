package com.kotlinground.datastructures.linkedlists

import java.security.MessageDigest

/**
 * LinkedListNode representation
 */
interface LinkedListNode<T> {
    val data: T
    val next: LinkedListNode<T>?
    val key: String?
        get() = lazy {
            val md = MessageDigest.getInstance("MD5")
            val digest = md.digest(data.toString().toByteArray())
            digest.toString()
        }
            .toString()
}
