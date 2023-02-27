package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.coroutines.flow.StateFlow

interface MergeableStateFlow<T : Mergeable<T>> : Mergeable<T>, StateFlow<T> {
    fun update(block: (state: T) -> T)
}
