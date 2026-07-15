package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val channel = Channel<Int>(capacity = 2, onBufferOverflow = BufferOverflow.DROP_OLDEST) {
        println("Undelivered element handler called on $it")
    }

    launch {
        repeat(5) {
            channel.send(it * 2)
            delay(100)
            println("Sent")
        }
        channel.close()
    }

    delay(1000)

    channel.consumeEach {
        println(it)
        delay(1000)
    }

    // output
    //  Sent
    //  Sent
    //  Sent
    //  Sent
    //  Sent
    //  6
    //  8
}
