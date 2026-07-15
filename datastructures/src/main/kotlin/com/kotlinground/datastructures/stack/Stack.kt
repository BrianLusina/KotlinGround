package com.kotlinground.datastructures.stack

/**
 * A generic stack implementation that follows the Last In, First Out (LIFO) principle.
 *
 * @param T the type of elements held in this stack.
 */
abstract class Stack<T: Comparable<T>>: Iterator<T> {
    abstract fun push(item: T)
    abstract fun pop(): T
    abstract fun peek(): T
    abstract val size: Int
    abstract val isEmpty: Boolean
}
