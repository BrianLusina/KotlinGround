package com.kotlinground.puzzles.arrays.jumpgame

fun jump(nums: IntArray): Int {
    val size = nums.size
    // destination is last index
    val destination = size - 1

    // record of current coverage, record of last jump index
    var currentCoverage = 0
    var lastJumpIndex = 0

    // min number of jumps
    var minJumps = 0

    // if start index == destination index == 0
    if (size == 1) {
        return 0
    }

    // Greedy strategy: extend coverage as long as possible with lazy jump
    for (idx in nums.indices) {
        // extend coverage as far as possible
        currentCoverage = maxOf(currentCoverage, idx + nums[idx])

        // forced to jump (by lazy jump) to extend coverage
        if (idx == lastJumpIndex) {
            // update last jump index
            lastJumpIndex = currentCoverage

            // update counter of jump by +1
            minJumps++

            // check if destination has been reached
            if (currentCoverage >= destination) {
                return minJumps
            }
        }
    }

    return minJumps
}
