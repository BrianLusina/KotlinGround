package com.kotlinground.datastructures.arrays.intersectionofarrays

fun setIntersection(setOne: Set<Int>, setTwo: Set<Int>): IntArray {
    return setOne.intersect(setTwo).toIntArray()
}

/**
 * Returns the intersection of two arrays. Uses a set to solve the problem in linear time. A set provides in/contains
 * operation in O(1) time in average case. This converts both arrays to sets and iterates over the smallest set
 * checking the presence of each element in the other larger set. The time complexity is O(n+m) where n is the size of
 * the first array and m is the size of the second array.
 */
fun intersectionOne(nums1: IntArray, nums2: IntArray): IntArray {
    val setOne = nums1.toSet()
    val setTwo = nums2.toSet()

    return if (setOne.size < setTwo.size) {
        setIntersection(setOne, setTwo)
    } else {
        setIntersection(setTwo, setOne)
    }
}
