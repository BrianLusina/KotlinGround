package com.kotlinground.puzzles.arrays.maxconsecutiveones

fun longestOnes(nums: IntArray, k: Int): Int {
    var left = 0
    var right = 0
    var x = k

    while (right < nums.size) {
        // if we encounter a 0 then we decrement k
        if (nums[right] == 0) {
            x--
        }

        // if k < 0 then we need to move the left part of the window forward
        // to try and remove the extra 0's
        if (x < 0) {
            // if the left one was zero then we adjust K
            if (nums[left] == 0) {
                x++
            }

            // regardless of whether we had a 1 or a 0 we can move left side by 1
            // if we keep seeing 1's the window still keeps moving as-is
            left++
        }

        right++
    }

    return right - left
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxConsecutiveOnes = 0
    var currentConsecutiveOnes = 0

    for (num in nums) {
        if (num == 1) {
            currentConsecutiveOnes++
            maxConsecutiveOnes = maxOf(maxConsecutiveOnes, currentConsecutiveOnes)
        } else {
            currentConsecutiveOnes = 0
        }
    }
    return maxConsecutiveOnes
}
