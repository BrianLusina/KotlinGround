package com.kotlinground.concurrency.coroutines.context

import kotlin.coroutines.CoroutineContext

/**
 * Custom context that implements the element of the CoroutineContext
 */
class CustomContext : CoroutineContext.Element {
    override val key: CoroutineContext.Key<*> = Key

    // Companion object must be specified with Key to make it identifiable
    companion object Key :
        CoroutineContext.Key<CustomContext>
}
