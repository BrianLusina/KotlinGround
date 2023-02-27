package com.kotlinground.datastructures.crdt.cvrdt

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MergeableStateFlowImplTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun multiple() =
        runTest { // this is a special TestScope which we use to inject in our other functions and control the structured concurrency
            val flowA = MergeableValue(0, Instant.fromEpochMilliseconds(0)).asStateFlow() // create one at t=0
            val flowB = MergeableValue(1, Instant.fromEpochMilliseconds(1)).asStateFlow() // create another one at t=1
            runCurrent() // this is a test function to run all the jobs currently in the job queue of the scheduler

            flowA.mergeWith(flowB, scope = this) // use the convenience function to subscribe and merge to its updates
            flowB.mergeWith(flowA, scope = this) // and vice-versa
            runCurrent()

            assertEquals(flowA.value, flowB.value) // they should now be equal even though they started different
            assertEquals(1, flowA.value.value)

            flowA.update {
                MergeableValue(
                    2,
                    Instant.fromEpochMilliseconds(2)
                )
            } // if we update one, the other should sync
            runCurrent()

            assertEquals(flowA.value, flowB.value)
            assertEquals(2, flowA.value.value)
            currentCoroutineContext().cancelChildren() // since the flows are HOT, they need to be cancelled
        }
}
