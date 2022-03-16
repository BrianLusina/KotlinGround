package com.kotlinground.datastructures.queues.fifo

import com.kotlinground.datastructures.queues.exceptions.QueueEmptyException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class ArrayListFifoQueueTest {
    @Test
    fun `Should enqueue items in the correct order`() {
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

    @Test
    fun `Should dequeue items in the correct order`() {
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

    @Test
    fun `Should peek first item without removing it`() {
        val queue = ArrayListFifoQueue<Int>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(3, queue.size)
        assertEquals(1, queue.peek())
        assertEquals(3, queue.size)
    }

    @Test
    fun `Should return true when isEmpty is called on empty queue`() {
        val queue = ArrayListFifoQueue<Int>()
        assertTrue(queue.isEmpty)
        queue.enqueue(1)
        assertFalse(queue.isEmpty)
    }

    @Test
    fun `Throw QueueEmptyException when there dequeue is called on empty queue`() {
        val queue = ArrayListFifoQueue<Int>()
        queue.enqueue(1)
        assertFalse(queue.isEmpty)
        queue.dequeue()
        assertTrue(queue.isEmpty)

        assertThrows(QueueEmptyException::class.java) {
            queue.dequeue()
        }
    }
}
