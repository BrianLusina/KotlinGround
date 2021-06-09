package com.kotlinground.ktmath.powersofi

fun powersofi(n: Int): String {
    return arrayListOf("1", "i", "-1", "-i")[n % 4]
}
