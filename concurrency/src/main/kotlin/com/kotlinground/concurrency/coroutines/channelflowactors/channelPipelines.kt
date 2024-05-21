package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.numbers(): ReceiveChannel<Int> = produce {
    repeat(3) {
        send(it + 1)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (num in numbers) {
        send(num * num)
    }
}

suspend fun main(): Unit = coroutineScope {
    val numbers = numbers()
    val squared = square(numbers)
    for (num in squared) {
        println(num)
    }

    // output
    //  1
    //  4
    //  9
}
