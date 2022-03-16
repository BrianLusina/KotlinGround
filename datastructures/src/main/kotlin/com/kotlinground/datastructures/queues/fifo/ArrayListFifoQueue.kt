package com.kotlinground.datastructures.queues.fifo

import com.kotlinground.datastructures.queues.exceptions.QueueEmptyException

/**
 * A first-in, first-out queue.
 * @param <T> the type of elements in this queue
 * A basic implementation of a fifo queue.
 * This assumes we don't care for the capacity of the queue. Uses a dynamic array to store the elements.
 */
class ArrayListFifoQueue<T> : FifoQueue<T>() {
    private val items = arrayListOf<T>()

    override val size: Int
        get() = items.size

    /**
     * Resizing is an O(n) operation. Resizing requires the list to allocate new memory and copy all existing data
     * over to the new list. Since this doesn’t happen very often (thanks to doubling the size each time),
     * the complexity still works out to be an amortized O(1).
     */
    override fun enqueue(item: T) {
        items.add(item)
    }

    /**
     * Removing an element from the front of the queue is an O(n) operation.
     * To dequeue, you remove the element from the beginning of the list.
     * This is always a linear time operation because it requires all of the remaining elements in the list to be
     * shifted in memory.
     */
    override fun dequeue(): T {
        if (items.isEmpty()) throw QueueEmptyException("Queue is empty")
        return items.removeAt(0)
    }

    override fun peek(): T {
        if (items.isEmpty()) throw QueueEmptyException("Queue is empty")
        return items[0]
    }
}
