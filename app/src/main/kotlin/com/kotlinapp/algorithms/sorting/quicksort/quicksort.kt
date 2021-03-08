package com.kotlinapp.algorithms.sorting.quicksort

// partitions a slice into 2 and returns the pivot index. Assumes the pivot is at the end of the slice
fun partition(theArray: Array<Int>, startIndex: Int, endIndex: Int): Int {

    val pivot = theArray[endIndex]

    var leftIndex = startIndex
    var rightIndex = endIndex - 1

    while (leftIndex <= rightIndex) {

        // walk until we find something on the left side that belongs on the right (less than the pivot)
        while (leftIndex <= endIndex && theArray[leftIndex] < pivot) {
            leftIndex++
        }

        // walk until we find something on the right side that belongs on the left(greater than or equal to the pivot)
        while (rightIndex >= startIndex && theArray[rightIndex] >= pivot) {
            rightIndex--
        }

        if (leftIndex < rightIndex) {
            // swap the items at the left_index and right_index, moving the element that's smaller than the pivot to the left
            // half and the element that's larger than the pivot to the right half
            val temp = theArray[leftIndex]
            theArray[leftIndex] = theArray[rightIndex]
            theArray[rightIndex] = temp
        } else {
            // unless we have looked at all the elements in the list and are done partitioning. In that case, move the pivot element
            // into it's final position
            val temp = theArray[leftIndex]
            theArray[leftIndex] = theArray[endIndex]
            theArray[endIndex] = temp
        }
    }

    return leftIndex
}

// quicksortSubArray uses recurstion to sort each partition of the slice
fun quicksortSubArray(theArray: Array<Int>, startIndex: Int, endIndex: Int) {

    // base case, list with 0 or 1 element
    if (startIndex >= endIndex) {
        return
    }

    // divide the list into 2 smaller sublists
    val pivotIndex = partition(theArray, startIndex, endIndex)

    // Recursively sort each sublist
    quicksortSubArray(theArray, startIndex, pivotIndex - 1)
    quicksortSubArray(theArray, pivotIndex + 1, endIndex)
}

// quicksort sorts a slice of integers using quicksort algorithm
fun quicksort(theArray: Array<Int>) {
    val length = theArray.size

    // Nothing to sort here
    if (length <= 1) {
        return
    }

    quicksortSubArray(theArray, 0, length - 1)
}
