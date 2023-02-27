package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T : Mergeable<T>> T.asStateFlow(): MergeableStateFlow<T> = MergeableStateFlowImpl(MutableStateFlow(this))

fun <T : Mergeable<T>> MergeableStateFlow<T>.mergeWith(other: MergeableStateFlow<T>, scope: CoroutineScope) {
    other
        .onEach { this.merge(it) }
        .launchIn(scope)
}
