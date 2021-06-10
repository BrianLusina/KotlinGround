package com.kotlinground.algorithms.permmissingelem

/**
 * Finds the missing element in a list of numbers
 * @param numbers [Array<Int>]
 * @return [Int] Missing element
 */
fun permMissingElement(numbers: IntArray): Int {
    var missingElement = numbers.size + 1

    numbers.forEachIndexed { index, it ->
        missingElement = missingElement xor it xor (index + 1)
    }

    return missingElement
}
