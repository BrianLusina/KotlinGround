package com.kotlinground.datastructures.queues

import com.kotlinground.datastructures.queues.exceptions.QueueEmptyException
import com.kotlinground.datastructures.queues.exceptions.QueueFullException

interface Queue<T> {
    /**
     * Size of the queue
     */
    val size: Int

    /**
     * Checks if the queue is empty
     */
    val isEmpty: Boolean
        get() = size == 0

    /**
     * Adds an element to the end of the queue.
     * @throws QueueFullException if the queue is full for bounded queues
     */
    @Throws(QueueFullException::class)
    fun enqueue(item: T)

    /**
     * Removes and returns the element at the beginning of the queue.
     * @throws QueueEmptyException if the queue is empty.
     */
    @Throws(QueueEmptyException::class)
    fun dequeue(): T

    /**
     * Returns the element at the beginning of the queue without removing it.
     * @throws QueueEmptyException if the queue is empty.
     */
    @Throws(QueueEmptyException::class)
    fun peek(): T
}
