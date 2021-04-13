package com.kotlinground.algorithms.sorting.mergesort


private fun combineSortedArrays(arrayOne: IntArray, arrayTwo: IntArray): IntArray {
    var arrayOneIndex = 0
    var arrayTwoIndex = 0
    var mergedArrayIndex = 0
    val mergedArray = IntArray(arrayOne.size + arrayTwo.size)

    // both arrays have some items left in them.
    while (arrayOneIndex < arrayOne.size && arrayTwoIndex < arrayTwo.size) {

        // choose the smaller of the two items and add it to the
        // merged array.
        if (arrayOne[arrayOneIndex] <= arrayTwo[arrayTwoIndex]) {
            mergedArray[mergedArrayIndex] = arrayOne[arrayOneIndex]
            arrayOneIndex += 1
        } else {
            mergedArray[mergedArrayIndex] = arrayTwo[arrayTwoIndex]
            arrayTwoIndex += 1
        }
        mergedArrayIndex += 1
    }

    // grab any lingering items in the first array after we've
    // exhausted the second array
    while (arrayOneIndex < arrayOne.size) {
        mergedArray[mergedArrayIndex] = arrayOne[arrayOneIndex]
        mergedArrayIndex += 1
        arrayOneIndex += 1
    }

    // grab any lingering items in the second array after we've
    // exhausted the first array
    while (arrayTwoIndex < arrayTwo.size) {
        mergedArray[mergedArrayIndex] = arrayTwo[arrayTwoIndex]
        mergedArrayIndex += 1
        arrayTwoIndex += 1
    }
    return mergedArray
}

fun mergeSort(theArray: IntArray): IntArray {

    // base case: single element array
    if (theArray.size <= 1) {
        return theArray
    }

    // split the input in half
    val middleIndex = theArray.size / 2
    val left: IntArray = theArray.copyOfRange(0, middleIndex)
    val right: IntArray = theArray.copyOfRange(middleIndex, theArray.size)

    // sort each half
    val leftSorted = mergeSort(left)
    val rightSorted = mergeSort(right)

    // merge the sorted halves
    return combineSortedArrays(leftSorted, rightSorted)
}