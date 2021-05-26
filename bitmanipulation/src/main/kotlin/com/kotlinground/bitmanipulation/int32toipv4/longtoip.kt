package com.kotlinground.bitmanipulation.int32toipv4

@ExperimentalUnsignedTypes
fun longToIP(ip: UInt): String {
    return "${ip shr 24}.${(ip shr 16) and 255u}.${(ip shr 8) and 255u}.${ip and 255u}"
}