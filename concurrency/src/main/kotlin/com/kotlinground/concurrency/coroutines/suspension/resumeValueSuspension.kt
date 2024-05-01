package com.kotlinground.concurrency.coroutines.suspension

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

var continuation: Continuation<Unit>? = null

suspend fun suspendAndSetContinuation() {
    suspendCoroutine { cont ->
        continuation = cont
    }
}

suspend fun main() = coroutineScope {
    println("Before again")

    launch {
        delay(1000)
        continuation?.resume(Unit)
    }

    suspendAndSetContinuation()

    println("After")
}
