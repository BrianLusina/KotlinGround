package com.kotlinground.concurrency.coroutines.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

suspend fun printName() {
    // coroutineContext can be accessed from a suspending function
    println(coroutineContext[CoroutineName]?.name)
}

fun main() = runBlocking(CoroutineName("main")) {
    log("started") // [main] started

    val v1 = async {
        delay(500L)
        log("running async") // [main] running async
        42
    }

    // child with a different context overriding the parent
    val v2 = async(CoroutineName("C1")) {
        delay(500L)
        log("running async") // [C1] running async
        42
    }

    launch {
        delay(1000L)
        log("running launch") // [main] running launch
    }

    // child with a different context overriding the parent
    launch(CoroutineName("C2")) {
        delay(1000L)
        log("running launch") // [main] running launch
    }

    log("The answer to life is ${v1.await()}") // [main] the answer to life is 42
    log("The answer to life is ${v2.await()}") // [main] the answer to life is 42

    printName()
}