package com.kotlinground.datastructures.linkedlists.circular

class CircularLinkedListIterator<T>(val start: CircularLinkedListNode<T>?) :
    Iterator<CircularLinkedListNode<T>> {
    private var currentNode = start

    override fun hasNext(): Boolean {
        return currentNode?.next != null && currentNode?.next != start
    }

    override fun next(): CircularLinkedListNode<T> {
        return currentNode?.next!!
    }
}
