package com.kotlinground.concurrency.coroutines.channelflowactors

private fun interface FlowCollector<T> {
    suspend fun emit(value: T)
}

private interface Flow<T> {
    suspend fun collect(collector: FlowCollector<T>)
}

private fun <T> flow(builder: suspend FlowCollector<T>.() -> Unit) = object : Flow<T> {
    override suspend fun collect(collector: FlowCollector<T>) {
        collector.builder()
    }
}

suspend fun main() {

    val f = flow {
        emit("A")
        emit("B")
        emit("C")
    }

    f.collect { print(it) }
    f.collect { print(it) }

    // ABCABC
}