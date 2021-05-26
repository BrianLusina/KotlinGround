package com.kotlinground.bitmanipulation.int32toipv4

import org.junit.jupiter.api.Test
import java.net.InetAddress
import java.nio.ByteBuffer
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.test.assertEquals

@ExperimentalUnsignedTypes
class LongtoipKtTest {

    @Test
    fun sampleTest() {
        assertEquals("128.114.17.104", longToIP(2154959208u))
        assertEquals("0.0.0.0", longToIP(0u))
        assertEquals("128.32.10.1", longToIP(2149583361u))
    }

    @Test
    fun randomTest() {
        for (test in 1..100) {
            val ip = Random.nextUInt()
            assertEquals(solution(ip), longToIP(ip))
        }
    }

    private fun solution(ip: UInt): String {
        return InetAddress.getByAddress(ByteBuffer.allocate(Int.SIZE_BYTES).putInt(ip.toInt()).array()).hostAddress
    }
}