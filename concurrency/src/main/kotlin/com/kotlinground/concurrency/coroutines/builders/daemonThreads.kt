package com.kotlinground.concurrency.coroutines.builders

import kotlin.concurrent.thread

fun main() {
    thread(isDaemon = true) {
        Thread.sleep(1000L)
        println("World!")
    }
    thread(isDaemon = true) {
        Thread.sleep(1000L)
        println("World!")
    }
    thread(isDaemon = true) {
        Thread.sleep(1000L)
        println("World!")
    }

    println("Hello,")
    Thread.sleep(2000L)
}