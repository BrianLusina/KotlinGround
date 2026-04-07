package com.kotlinground.datastructures.stack.dynamic

import com.kotlinground.datastructures.stack.Stack

class DynamicSizedStack<T>: Stack<T>() {
    private val items = mutableListOf<T>()
    private var currentSize = 0

    override fun push(item: T) {
        currentSize++
        items.add(item)
    }

    override fun pop(): T {
        if (items.isEmpty()) {
            throw IllegalStateException("Stack underflow: empty stack")
        }
        currentSize--
        return items.removeAt(currentSize)
    }

    override fun peek(): T {
        if (items.isEmpty()) {
            throw IllegalStateException("Stack is empty")
        }
        return items[currentSize - 1]
    }

    override val size: Int
        get() = items.size

    override val isEmpty: Boolean
        get() = items.isEmpty()

    override fun next(): T {
        return items[--currentSize]
    }

    override fun hasNext(): Boolean {
        return currentSize > 0
    }
}
