package com.kotlinground.concurrency.coroutines.cancellation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Caught $throwable in $coroutineContext")
    }
    val scope = CoroutineScope(SupervisorJob() + handler)

    scope.launch {
        delay(1000)
        throw Error("Some error")
    }

    scope.launch {
        delay(2000)
        println("Will be printed")
    }

    delay(3000)

    // output
    // Caught java.lang.Error: Some error in [com.kotlinground.concurrency.coroutines.cancellation.ExceptionHandlingHandlerKt$main$2$invokeSuspend$$inlined$CoroutineExceptionHandler$1@563e0731, StandaloneCoroutine{Cancelling}@1f8c95ae, Dispatchers.Default]
    //Will be printed
}