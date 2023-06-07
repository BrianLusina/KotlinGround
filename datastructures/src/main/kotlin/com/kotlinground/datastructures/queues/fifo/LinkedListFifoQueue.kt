package com.kotlinground.datastructures.queues.fifo

import com.kotlinground.datastructures.linkedlists.doubly.DoublyLinkedList
import com.kotlinground.datastructures.queues.exceptions.QueueEmptyException

/**
 * A first-in, first-out queue with a linked list implementation.
 * @param <T> the type of elements in this queue
 * A basic implementation of a fifo queue.
 * This assumes we don't care for the capacity of the queue. Uses a doubly linked list to store the elements.
 */
class LinkedListFifoQueue<T> : FifoQueue<T>() {
    private val items = DoublyLinkedList<T>()

    override val size: Int
        get() = items.size

    override fun enqueue(item: T) {
        items.append(item)
    }

    override fun dequeue(): T {
        if (items.isEmpty()) throw QueueEmptyException("Queue is empty")
        return items.shift() ?: throw QueueEmptyException("Queue is empty")
    }

    override fun peek(): T {
        if (items.isEmpty()) throw QueueEmptyException("Queue is empty")
        val node = items.headNode() ?: throw QueueEmptyException("Queue is empty")
        return node.data
    }
}
