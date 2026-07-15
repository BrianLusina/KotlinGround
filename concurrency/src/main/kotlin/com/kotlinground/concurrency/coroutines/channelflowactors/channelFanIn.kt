package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> CoroutineScope.fanIn(channels: List<ReceiveChannel<T>>): ReceiveChannel<T> = produce {
    for (channel in channels) {
        launch {
            for (elem in channel) {
                send(elem)
            }
        }
    }
}

suspend fun sendString(channel: SendChannel<String>, text: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(text)
    }
}

fun main(): Unit = runBlocking {
    val channel = Channel<String>()
    launch { sendString(channel, "foo", 200L) }
    launch { sendString(channel, "BAR", 500L) }
    repeat(50) {
        println(channel.receive())
    }

    coroutineContext.cancelChildren()

    // output
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
    //foo
    //BAR
    //foo
    //foo
    //BAR
    //foo
    //foo
}
