package com.kotlinground.datastructures.utils


operator fun Number.rem(other: Int): Number {
    return when (this) {
        is Long -> this.toLong().mod(other)
        is Int -> this.toInt().mod(other)
        is Short -> this.toShort().mod(other)
        is Byte -> this.toByte().mod(other)
        is Double -> this.toDouble().mod(other.toDouble())
        is Float -> this.toFloat().mod(other.toDouble())
        else -> throw RuntimeException("Unknown numeric type")
    }
}

operator fun Number.plus(other: Number): Number {
    return when (this) {
        is Long -> this.toLong() + other.toLong()
        is Int -> this.toInt() + other.toInt()
        is Short -> this.toShort() + other.toShort()
        is Byte -> this.toByte() + other.toByte()
        is Double -> this.toDouble() + other.toDouble()
        is Float -> this.toFloat() + other.toFloat()
        else -> throw RuntimeException("Unknown numeric type")
    }
}

operator fun Any.rem(other: Int): Number {
    return when (this) {
        is Long -> this.toLong().mod(other)
        is Int -> this.toInt().mod(other)
        is Short -> this.toShort().mod(other)
        is Byte -> this.toByte().mod(other)
        is Double -> this.toDouble().mod(other.toDouble())
        is Float -> this.toFloat().mod(other.toDouble())
        else -> throw RuntimeException("Unknown numeric type")
    }
}

operator fun Any.plus(other: Number): Number {
    return when (this) {
        is Long -> this.toLong() + other.toLong()
        is Int -> this.toInt() + other.toInt()
        is Short -> this.toShort() + other.toShort()
        is Byte -> this.toByte() + other.toByte()
        is Double -> this.toDouble() + other.toDouble()
        is Float -> this.toFloat() + other.toFloat()
        else -> throw RuntimeException("Unknown numeric type")
    }
}

operator fun <T> T.plus(data: T): Any {
    return when (data) {
        is Int -> this as Int + data
        is Float -> this as Float + data
        is String -> this as String + data
        is Short -> this as Short + data
        is Byte -> this as Byte + data
        is Double -> this as Double + data
        else -> {
            throw RuntimeException("Unsupported data type")
        }
    }
}
