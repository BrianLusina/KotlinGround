package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.async
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.selects.select

suspend fun askMultipleForData2(): String = coroutineScope {
    val defData1 = async { requestData1() }
    val defData2 = async { requestData2() }

    select {
        defData1.onAwait { it }
        defData2.onAwait { it }
    }
        .also { coroutineContext.cancelChildren() }
}

suspend fun main() = coroutineScope {
    println(askMultipleForData2())

    // output
    // Data2
}