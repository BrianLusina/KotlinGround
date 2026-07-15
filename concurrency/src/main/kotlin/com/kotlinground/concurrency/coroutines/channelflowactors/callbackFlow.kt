package com.kotlinground.concurrency.coroutines.channelflowactors

import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlin.coroutines.cancellation.CancellationException

private interface Callback<T> {
    fun onNextValue(value: T)

    fun onApiError(cause: Throwable)

    fun onCompleted(): Boolean
}

private interface CallbackBasedApi<T> {
    fun register(cb: Callback<T>)
    fun unregister(cb: Callback<T>)
}

private fun <T> flowFrom(api: CallbackBasedApi<T>): Flow<T> = callbackFlow {
    val callback = object : Callback<T> {
        override fun onNextValue(value: T) {
            runCatching {
                trySendBlocking(value)
            }
                .getOrElse {
                    // Handle exception from the channel:
                    // failure in flow or premature closing
                }
        }

        override fun onApiError(cause: Throwable) {
            cancel(CancellationException("API Error", cause))
        }

        override fun onCompleted() = channel.close()
    }
    api.register(callback)
    awaitClose { api.unregister(callback) }
}
