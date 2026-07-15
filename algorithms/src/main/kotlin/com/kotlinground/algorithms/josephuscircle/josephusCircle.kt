package com.kotlinground.algorithms.josephuscircle

import com.kotlinground.datastructures.linkedlists.circular.CircularLinkedList
import com.kotlinground.datastructures.linkedlists.circular.CircularLinkedListNode

fun <T> josephusCircle(circularList: CircularLinkedList<T>, step: Int): CircularLinkedListNode<T> {
    var current = circularList.headNode()

    var length = circularList.size()
    while (length > 1) {
        var count = 1
        while (count != step) {
            current = current?.next
            count += 1
        }
        circularList.deleteNode(current!!)
        current = current.next
        length -= 1
    }

    return current!!
}
