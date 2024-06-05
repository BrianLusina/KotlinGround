package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry

suspend fun main() {
    flow {
        emit(1)
        emit(2)
        error("E")
        emit(3)
    }
        .retry(3) {
            print(it.message)
            true
        }
        .collect(::print)
    // 12E12E12E12Exception in thread "main" java.lang.IllegalStateException: E
}
