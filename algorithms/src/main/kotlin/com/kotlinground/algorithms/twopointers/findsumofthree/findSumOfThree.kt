package com.kotlinground.algorithms.twopointers.findsumofthree

fun findSumOfThree(numbers: IntArray, target: Int): Boolean {
    numbers.sort()

    for (idx in 0..numbers.size-2) {
        var low = idx + 1
        var high = numbers.size - 1

        while (low < high) {
            val currentSum = numbers[idx] + numbers[low] + numbers[high]

            if (currentSum == target) {
                return true
            } else if (currentSum < target) {
                low += 1
            } else {
                high -= 1
            }
        }
    }

    return false
}
