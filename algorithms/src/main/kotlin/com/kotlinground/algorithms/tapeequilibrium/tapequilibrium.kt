package com.kotlinground.algorithms.tapeequilibrium

import kotlin.math.abs
import kotlin.math.min

/**
 * Finds the minimum difference between 2 parts of a tape
 * @param tape [Array] Array of integer values denoting points on a tape
 * @return [Int] minimum difference between 2 parts on a tape
 */
fun tapeEquilibrium(tape: IntArray): Int {
    var parts = arrayOfNulls<Int>(tape.size)

    for (index in 1..tape.size) {
        parts[index] = tape[index] + parts[index - 1]!!
    }

    var difference = Int.MAX_VALUE

    for (idx in parts.indices) {
        difference = min(difference, abs(parts[-1]?.minus(2 * parts[idx]!!)!!))
    }

    return difference
}
