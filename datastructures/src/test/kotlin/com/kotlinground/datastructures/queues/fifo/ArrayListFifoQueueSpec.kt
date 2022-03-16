package com.kotlinground.datastructures.queues.fifo

import com.kotlinground.datastructures.queues.exceptions.QueueEmptyException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertFalse
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object ArrayListFifoQueueSpec : Spek({
    describe("Enqueue operation") {
        it("should enqueue items in the correct order") {
            val queue = ArrayListFifoQueue<Int>()
            queue.enqueue(1)
            queue.enqueue(2)
            queue.enqueue(3)
            assertEquals(3, queue.size)

            assertEquals(1, queue.dequeue())
            assertEquals(2, queue.size)

            assertEquals(2, queue.dequeue())
            assertEquals(1, queue.size)

            assertEquals(3, queue.dequeue())
            assertEquals(0, queue.size)
        }
    }

    describe("dequeue operation") {
        it("should dequeue items in the correct order") {
            val queue = ArrayListFifoQueue<Int>()
            queue.enqueue(1)
            queue.enqueue(2)
            queue.enqueue(3)
            assertEquals(3, queue.size)
            assertEquals(1, queue.dequeue())
            assertEquals(2, queue.dequeue())
            assertEquals(3, queue.dequeue())
            assertEquals(0, queue.size)
        }
    }

    describe("should return true when isEmpty is called on empty queue") {
        it("should return true") {
            val queue = ArrayListFifoQueue<Int>()
            assertTrue(queue.isEmpty)
            queue.enqueue(1)
            assertFalse(queue.isEmpty)
        }
    }

    describe("Throw QueueEmptyException when there dequeue is called on empty queue") {
        val queue = ArrayListFifoQueue<Int>()
        queue.enqueue(1)
        assertFalse(queue.isEmpty)
        queue.dequeue()
        assertTrue(queue.isEmpty)

        assertThrows(QueueEmptyException::class.java) {
            queue.dequeue()
        }
    }
})
