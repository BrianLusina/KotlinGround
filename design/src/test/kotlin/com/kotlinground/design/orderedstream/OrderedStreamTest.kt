package com.kotlinground.design.orderedstream

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class OrderedStreamTest {

    @Test
    fun `Test on OrderedStream with n = 5`() {
        val n = 5
        val orderedStream = OrderedStream(n)

        val insert3 = orderedStream.insert(4, "ccccc")

        Assertions.assertEquals(listOf<String>(), insert3)
    }
}