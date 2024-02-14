package com.kotlinground.puzzles.arrays.jumpgame

fun canJump(nums: IntArray): Boolean {
    var currentPosition = nums[0]

    for (idx in 1 until nums.size) {
        if (currentPosition == 0) {
            return false
        }

        currentPosition -= 1

        currentPosition = maxOf(currentPosition, nums[idx])
    }

    return true
}
