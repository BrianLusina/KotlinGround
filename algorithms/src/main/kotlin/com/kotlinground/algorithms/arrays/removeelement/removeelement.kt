package com.kotlinground.algorithms.arrays.removeelement

fun removeElement(nums: IntArray, `val`: Int): Int {
    var pointer = 0
    var size = nums.size

    while (pointer < size) {
        if (nums[pointer] == `val`) {
            nums[pointer] = nums[size - 1]
            size--
        } else {
            pointer++
        }
    }

    return size
}
