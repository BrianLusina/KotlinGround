package com.kotlinground.datastructures.stack.min

import com.kotlinground.datastructures.stack.dynamic.DynamicSizedStack

class MinStack<T : Comparable<T>>: DynamicSizedStack<T>() {
    // Keeps track of the current minimum of the stack
    private var currentMin: T? = null

    override fun push(item: T) {
        super.push(item)
        if (currentMin == null) {
            currentMin = item
        } else {
            if (item < currentMin!!)
                currentMin = item
        }
    }

    override fun pop(): T {
        val item = super.pop()
        if (size == 0) {
            currentMin = null
        } else if (item == currentMin) {
            currentMin = items.min()
        }
        return item
    }

    override fun peek(): T {
        return super.peek()
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
