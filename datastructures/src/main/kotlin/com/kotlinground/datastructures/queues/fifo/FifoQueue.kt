package com.kotlinground.datastructures.queues.fifo

import com.kotlinground.datastructures.queues.Queue
import com.kotlinground.datastructures.queues.exceptions.QueueEmptyException

/**
 * A first-in, first-out queue.
 * @param <T> the type of elements in this queue
 * A basic implementation of a fifo queue.
 * This assumes we don't care for the capacity of the queue. Uses a dynamic array to store the elements.
 */
open class FifoQueue<T> : Queue<T> {
    private val items = mutableListOf<T>()

    override val size: Int
        get() = items.size

    override fun enqueue(item: T) {
        items.add(item)
    }

    override fun dequeue(): T {
        if (items.isEmpty()) throw QueueEmptyException("Queue is empty")
        return items.removeAt(0)
    }

    override fun peek(): T {
        if (items.isEmpty()) throw QueueEmptyException("Queue is empty")
        return items[0]
    }
}
