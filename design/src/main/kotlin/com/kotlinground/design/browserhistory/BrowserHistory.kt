package com.kotlinground.design.browserhistory

import com.kotlinground.datastructures.linkedlists.doubly.DoublyLinkedListNode

class BrowserHistory(homepage: String) {
    private var currentNode = DoublyLinkedListNode(homepage)

    fun visit(url: String) {
        val newNode = DoublyLinkedListNode(url)
        currentNode.next = newNode
        newNode.previous = currentNode
        currentNode = newNode
    }

    fun back(steps: Int): String {
        for (i in 0 until steps) {
            if (currentNode.previous != null) {
                currentNode = currentNode.previous!!
            }
        }
        return currentNode.data
    }

    fun forward(steps: Int): String {
        for (i in 0 until steps) {
            if (currentNode.next != null) {
                currentNode = currentNode.next!!
            }
        }
        return currentNode.data
    }
}
