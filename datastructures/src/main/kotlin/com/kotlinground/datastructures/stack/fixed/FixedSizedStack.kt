package com.kotlinground.datastructures.stack.fixed

import com.kotlinground.datastructures.stack.Stack

/**
 * A stack implementation with a fixed maximum size. This stack prevents dynamically resizing the storage
 * and enforces a strict limit on the number of elements it can hold.
 *
 * @param T the type of elements held in this stack.
 * @param maxSize the maximum number of elements the stack can hold (must be > 0).
 */
class FixedSizedStack<T : Comparable<T>>(maxSize: Int) : Stack<T>() {
    private val items: Array<Any?>
    private var currentSize = 0

    init {
        require(maxSize > 0) { "maxSize must be > 0, was $maxSize" }
        items = arrayOfNulls(maxSize)
    }

    override fun push(item: T) {
        if (currentSize == items.size) {
            throw IllegalStateException("Stack overflow: capacity=${items.size}")
        }
        items[currentSize++] = item
    }

    override fun pop(): T {
        if (currentSize == 0) {
            throw IllegalStateException("Stack underflow: empty stack")
        }
        val idx = --currentSize
        @Suppress("UNCHECKED_CAST")
        val value = items[idx] as T
        // help GC by preventing loitering of unused items by setting them to null
        items[idx] = null
        return value
    }

    override fun peek(): T {
        if (currentSize == 0) {
            throw IllegalStateException("Empty stack")
        }
        @Suppress("UNCHECKED_CAST")
        return items[currentSize - 1] as T
    }

    override val size: Int
        get() = currentSize

    override val isEmpty: Boolean
        get() = currentSize == 0

    override fun next(): T {
        @Suppress("UNCHECKED_CAST")
        return items[--currentSize] as T
    }

    override fun hasNext(): Boolean {
        return currentSize > 0
    }
}
