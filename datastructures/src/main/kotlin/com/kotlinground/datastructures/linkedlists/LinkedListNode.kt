package com.kotlinground.datastructures.linkedlists

/**
 * LinkedListNode representation
 */
interface LinkedListNode<T> {
    val data: T
    val next: LinkedListNode<T>?
}
