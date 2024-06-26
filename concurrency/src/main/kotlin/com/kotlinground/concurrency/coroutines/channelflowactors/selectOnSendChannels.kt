package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select


fun main(): Unit = runBlocking {
    val c1 = Channel<Char>(capacity = 2)
    val c2 = Channel<Char>(capacity = 2)

    launch {
        for (c in 'A'..'H') {
            delay(400)
            select {
                c1.onSend(c) {
                    println("Sent $c to 1")
                }

                c2.onSend(c) {
                    println("Send $c to 2")
                }
            }
        }
    }

    launch {
        while (true) {
            delay(1000)
            val c = select {
                c1.onReceive { "$it from 1" }
                c2.onReceive { "$it from 2" }
            }

            println("Received $c")
        }
    }

    //  Sent A to 1
    //  Sent B to 1
    //  Received A from 1
    //  Sent C to 1
    //  Send D to 2
    //  Received B from 1
    //  Sent E to 1
    //  Send F to 2
    //  Received C from 1
    //  Sent G to 1
    //  Received E from 1
    //  Sent H to 1
    //  Received G from 1
    //  Received H from 1
    //  Received D from 2
    //  Received F from 2
}