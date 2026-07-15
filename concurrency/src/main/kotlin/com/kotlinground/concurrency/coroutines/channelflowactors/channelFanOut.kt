package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceNumbers(max: Int = 10, delayInMillis: Long = 100) = produce {
    repeat(max) {
        delay(delayInMillis)
        send(it)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        println("#$id received $msg")
    }
}

suspend fun main(): Unit = coroutineScope {
    val channel = produceNumbers()
    repeat(3) {
        delay(10)
        launchProcessor(it, channel)
    }

    // output
    //  #0 received 0
    //  #1 received 1
    //  #2 received 2
    //  #0 received 3
    //  #1 received 4
    //  #2 received 5
    //  #0 received 6
    //  #1 received 7
    //  #2 received 8
    //  #0 received 9
}
