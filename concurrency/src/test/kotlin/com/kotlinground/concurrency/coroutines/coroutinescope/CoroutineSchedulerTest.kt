package com.kotlinground.concurrency.coroutines.coroutinescope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class CoroutineSchedulerTest {

    @Test
    fun `advance time`() {
        val scheduler = TestCoroutineScheduler()

        println(scheduler.currentTime) // 0
        scheduler.advanceTimeBy(1_000)

        println(scheduler.currentTime) // 1000

        scheduler.advanceTimeBy(1_000)
        println(scheduler.currentTime) //2000
    }

    @Test
    fun `advance time using standard dispatcher`() {
        val scheduler = TestCoroutineScheduler()
        val testDispatcher = StandardTestDispatcher(scheduler)

        CoroutineScope(testDispatcher).launch {
            println("Working 1")
            delay(1000)

            println("Working 2")
            delay(1000)

            println("Done")
        }

        println("[${scheduler.currentTime}] Before") // [0] Before
        // Working 1
        // Working 2
        // Done
        scheduler.advanceUntilIdle()

        println("[${scheduler.currentTime}] After") // [2000] After
    }

    @Test
    fun `advance time using standard dispatcher without explicit scheduler invocation`() {
        val testDispatcher = StandardTestDispatcher()

        CoroutineScope(testDispatcher).launch {
            println("Working 1")
            delay(1000)

            println("Working 2")
            delay(1000)

            println("Done")
        }

        println("[${testDispatcher.scheduler.currentTime}] Before") // [0] Before
        // Working 1
        // Working 2
        // Done
        testDispatcher.scheduler.advanceUntilIdle()

        println("[${testDispatcher.scheduler.currentTime}] After") // [2000] After
    }

    @Test
    fun `advance time using standard dispatcher with advanceTimeBy`() {
        val testDispatcher = StandardTestDispatcher()

        CoroutineScope(testDispatcher).launch {
            delay(1)
            println("Done1")
        }

        CoroutineScope(testDispatcher).launch {
            delay(2)
            println("Done2")
        }

        testDispatcher.scheduler.advanceTimeBy(2) // Done1
        testDispatcher.scheduler.runCurrent() // Done2
    }

    @Test
    fun `advance time using standard dispatcher with advanceTimeBy advanced`() {
        val testDispatcher = StandardTestDispatcher()

        CoroutineScope(testDispatcher).launch {
            delay(2)
            print("Done1")
        }

        CoroutineScope(testDispatcher).launch {
            delay(4)
            print("Done2")
        }

        CoroutineScope(testDispatcher).launch {
            delay(6)
            print("Done3")
        }

        for (i in 1..5) {
            print(".")
            testDispatcher.scheduler.advanceTimeBy(1)
            testDispatcher.scheduler.runCurrent()
        }
        // ..Done1..Done2.
    }

    @Test
    fun `virtual time using standard dispatcher is not affected by real time`() {
        val testDispatcher = StandardTestDispatcher()

        CoroutineScope(testDispatcher).launch {
            delay(1000)
            println("Coroutine Done")
        }

        Thread.sleep(Random.nextLong(2000)) // Does not matter how much time we wait here, it will not influence the
        // result

        val time = measureTimeMillis {
            println("[${testDispatcher.scheduler.currentTime}] Before")
            testDispatcher.scheduler.advanceUntilIdle()
            println("[${testDispatcher.scheduler.currentTime}] After")
        }

        println("Took $time ms")
        // [0] Before
        // Coroutine Done
        // [1000] After
        // Took 29 ms // or other small number
    }

    @Test
    fun `using test scope`() {
        val scope = TestScope()

        scope.launch {
            delay(1000)
            println("First Done")

            delay(1000)
            println("Coroutine Done")
        }

        println("[${scope.currentTime}] Before") // [0] Before
        scope.advanceTimeBy(1000)
        scope.runCurrent() // First Done
        println("[${scope.currentTime}] Middle") // [1000] Middle
        scope.advanceUntilIdle() // Coroutine Done
        println("[${scope.currentTime}] After") // [2000] After
    }

    @Test
    fun `using runTest`() = runTest {
        assertEquals(0, currentTime)
        delay(1000)
        assertEquals(1000, currentTime)
    }

    @Test
    fun `using runTest 2`() = runTest {
        assertEquals(0, currentTime)
        coroutineScope {
            launch { delay(1000) }
            launch { delay(1500) }
            launch { delay(2000) }
        }
        assertEquals(2000, currentTime)
    }
}
