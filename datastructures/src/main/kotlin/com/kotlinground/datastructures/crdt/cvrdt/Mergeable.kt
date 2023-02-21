package com.kotlinground.datastructures.crdt.cvrdt

/**
 * This interface only ensures us that a Mergeable value can merge with another one and returns a value of the same
 * type that is also Mergeable.
 */
interface Mergeable<T> where T : Mergeable<T> {
    fun merge(incoming: T): T
}
