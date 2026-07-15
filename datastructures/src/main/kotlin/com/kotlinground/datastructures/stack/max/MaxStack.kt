package com.kotlinground.datastructures.stack.max

import com.kotlinground.datastructures.stack.dynamic.DynamicSizedStack

class MaxStack<T : Comparable<T>>: DynamicSizedStack<T>() {
    // Keeps track of the current maximum in the stack
    private var currentMax: T? = null

    override fun push(item: T) {
        super.push(item)
        if (currentMax == null) {
            currentMax = item
        } else {
            if (item > currentMax!!)
                currentMax = item
        }
    }

    override fun pop(): T {
        val item = super.pop()
        if (size == 0) {
            currentMax = null
        } else if (item == currentMax) {
            currentMax = items.max()
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
