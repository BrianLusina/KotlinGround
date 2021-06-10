package com.kotlinground.algorithms.arrays.removeelement

fun removeElement(nums: IntArray, value: Int): Int {
    var pointer = 0
    var size = nums.size

    while (pointer < size) {
        if (nums[pointer] == value) {
            nums[pointer] = nums[size - 1]
            size--
        } else {
            pointer++
        }
    }

    return size
}
