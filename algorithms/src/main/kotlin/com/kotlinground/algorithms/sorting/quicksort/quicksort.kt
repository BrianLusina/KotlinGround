package com.kotlinground.algorithms.sorting.quicksort

// partitions a slice into 2 and returns the pivot index. Assumes the pivot is at the end of the slice
fun <T> partition(collection: Array<T>, startIndex: Int, endIndex: Int): Int {

    val pivot = collection[endIndex]

    var leftIndex = startIndex
    var rightIndex = endIndex - 1

    while (leftIndex <= rightIndex) {

        // walk until we find something on the left side that belongs on the right (less than the pivot)
        while (leftIndex <= endIndex && collection[leftIndex] < pivot) {
            leftIndex++
        }

        // walk until we find something on the right side that belongs on the left(greater than or equal to the pivot)
        while (rightIndex >= startIndex && collection[rightIndex] >= pivot) {
            rightIndex--
        }

        if (leftIndex < rightIndex) {
            // swap the items at the left_index and right_index, moving the element that's smaller than the pivot to
            // the left
            // half and the element that's larger than the pivot to the right half
            val temp = collection[leftIndex]
            collection[leftIndex] = collection[rightIndex]
            collection[rightIndex] = temp
        } else {
            // unless we have looked at all the elements in the list and are done partitioning. In that case, move the
            // pivot element
            // into it's final position
            val temp = collection[leftIndex]
            collection[leftIndex] = collection[endIndex]
            collection[endIndex] = temp
        }
    }

    return leftIndex
}

private operator fun <T> T.compareTo(pivot: T): Int {
    TODO("Not yet implemented")
}

// quicksortSubArray uses recurstion to sort each partition of the slice
fun <T> quicksortSubCollection(collection: Array<T>, startIndex: Int, endIndex: Int) {

    // base case, list with 0 or 1 element
    if (startIndex >= endIndex) {
        return
    }

    // divide the list into 2 smaller sub lists
    val pivotIndex = partition(collection, startIndex, endIndex)

    // Recursively sort each sublist
    quicksortSubCollection(collection, startIndex, pivotIndex - 1)
    quicksortSubCollection(collection, pivotIndex + 1, endIndex)
}

// quicksort sorts a slice of integers using quicksort algorithm
fun <T> quicksort(collection: Array<T>): Array<T> {
    val length = collection.size
    collection.reversed()

    // Nothing to sort here
    if (length <= 1) {
        return collection
    }

    quicksortSubCollection(collection, 0, length - 1)
    return collection
}
