package com.kotlinground.algorithms.arrays.sortedsquaredarray

import kotlin.math.abs

fun sortedSquaredArray(array: List<Int>): List<Int> {
    val length = array.size
    if (array.isEmpty()) {
        return emptyList()
    }
    val result = MutableList(length, {0})
    var left = 0
    var right = length-1

    for (i in length-1 downTo 0) {
        val leftAbs = abs(array[left])
        val rightAbs = abs(array[right])

        if (leftAbs > rightAbs) {
            val square = leftAbs * leftAbs
            result[i] = square
            left++
        } else {
            val square = rightAbs * rightAbs
            result[i] = square
            right--
        }
    }

    return result
}

/**
 * Generic version that works with any Comparable type
 */
fun <T> Array<T>.sortedSquaredArrayGeneric(
    square: (T) -> T,
    abs: (T) -> T,
    compare: (T, T) -> Int
): Array<T> {
    val n = this.size
    @Suppress("UNCHECKED_CAST")
    val result = arrayOfNulls<Any>(n) as Array<T>
    var left = 0
    var right = n - 1

    for (i in n - 1 downTo 0) {
        val leftAbs = abs(this[left])
        val rightAbs = abs(this[right])

        if (compare(leftAbs, rightAbs) > 0) {
            result[i] = square(this[left])
            left++
        } else {
            result[i] = square(this[right])
            right--
        }
    }

    return result
}
