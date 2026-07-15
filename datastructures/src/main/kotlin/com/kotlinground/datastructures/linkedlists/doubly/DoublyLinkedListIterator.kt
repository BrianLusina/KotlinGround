package com.kotlinground.datastructures.linkedlists.doubly

class DoublyLinkedListIterator<T>(val start: DoublyLinkedListNode<T>?) :
    Iterator<DoublyLinkedListNode<T>> {
    private var currentNode = start

    override fun hasNext(): Boolean {
        return currentNode?.next != null
    }

    override fun next(): DoublyLinkedListNode<T> {
        return currentNode?.next!!
    }
}
