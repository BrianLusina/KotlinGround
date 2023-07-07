package com.kotlinground.puzzles.arrays.finddiffoftwoarrays

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    fun getElementsInFirstList(firstList: IntArray, secondList: IntArray): List<Int> {
        val firstListSet = hashSetOf<Int>()

        val secondListSet = hashSetOf<Int>()
        for (num in secondList) {
            secondListSet.add(num)
        }

        for (num in firstList) {
            if (!secondListSet.contains(num)) {
                firstListSet.add(num)
            }
        }

        return firstListSet.toList()
    }

    return listOf(getElementsInFirstList(nums1, nums2), getElementsInFirstList(nums2, nums1))
}
