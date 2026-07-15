package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withTimeout
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UsingWithTimeoutTest {
    @Test
    fun `test time`() = runTest {
        withTimeout(1000) {
            // something that should take less than 1000
            delay(900) // virtual time
        }
    }

    @Test
    fun `test time 2`() = runTest {
        assertThrows<TimeoutCancellationException> {
            withTimeout(1000) {
                // something that should take more than 1000
                delay(1100) //virtual time
            }
        }
    }

    @Test
    fun `test time 3`() = runBlocking {
        withTimeout(1000) {
            // normal test that should not take long
            delay(900) // real waiting time
        }
    }
}