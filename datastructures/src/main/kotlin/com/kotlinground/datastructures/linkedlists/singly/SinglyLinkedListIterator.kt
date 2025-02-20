package com.kotlinground.datastructures.linkedlists.singly

class SinglyLinkedListIterator<T>(val start: SinglyLinkedListNode<T>?): Iterator<SinglyLinkedListNode<T>> {
    private var currentNode = start

    override fun next(): SinglyLinkedListNode<T> {
        return currentNode?.next!!
    }

    override fun hasNext(): Boolean {
        return currentNode?.next !== null
    }
}
