package com.kotlinground.datastructures.stack.dynamic

import com.kotlinground.datastructures.stack.Stack
import com.kotlinground.datastructures.utils.NullableWrapper

open class DynamicSizedStack<T : Comparable<T>>: Stack<T>() {
    protected val items = mutableListOf<T>()
    protected var currentSize = 0

    companion object{
        /**
         * Extension function to create a stack for nullable values.
         * Usage: val stack = DynamicSizedStack.forNullable<Int>()
         */
        fun <T : Comparable<T>> forNullable(): DynamicSizedStack<NullableWrapper<T>> {
            return DynamicSizedStack()
        }
    }

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
