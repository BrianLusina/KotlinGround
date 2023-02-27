package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MergeableStateFlowImpl<T : Mergeable<T>>(private val _states: MutableStateFlow<T>) : MergeableStateFlow<T>,
    StateFlow<T> by _states {

    override fun merge(incoming: T): T {
        _states.update { it.merge(incoming) }
        return value
    }

    override fun update(block: (state: T) -> T) {
        _states.update(block)
    }
}
