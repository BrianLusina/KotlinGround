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

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) {
        return nums.size
    }

    var previous = 1 // points to previous
    var current = 2 // points to current

    while (current < nums.size) {
        // if the current index matches the previous two elements, skip it
        if (nums[current] == nums[previous] && nums[current] == nums[previous - 1]) {
            current++
        } else {
            // otherwise, count that element and update
            previous++
            nums[previous] = nums[current]
            current++
        }
    }
    // return previous after placing the final result in the first previous slots of nums
    return previous + 1
}
