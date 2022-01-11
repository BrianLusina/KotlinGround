package com.kotlinground.datastructures.arrays.containsduplicates

fun containsDuplicate(nums: IntArray): Boolean {
    return nums.toList().groupingBy { it }.eachCount().any { it.value > 1 }
}
