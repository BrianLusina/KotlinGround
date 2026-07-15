package com.kotlinground.algorithms.arrays.validsubsequence

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    if (array.isEmpty() || sequence.size > array.size) {
        return false
    }

    var i = 0
    var j = 0

    while (i < sequence.size && j < array.size) {
        if (sequence[i] == array[j]) {
            i += 1;
        }
        j += 1;
    }
    return i == sequence.size
}

fun isValidSubsequenceV2(array: List<Int>, sequence: List<Int>): Boolean {
    if (array.isEmpty() || sequence.size > array.size) {
        return false
    }

    var seek = 0

    for (i in 0 until array.size) {
        if (sequence[seek] == array[i]) {
            seek += 1
        }
        if (seek == sequence.size) {
            return true
        }
    }

    return false
}
