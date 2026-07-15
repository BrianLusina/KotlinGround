package com.kotlinground.algorithms.heap.mergeksortedlists

import java.util.PriorityQueue

fun mergeKLists(lists: List<List<Int>>): List<Int> {
    // Validate that the input provided is not empty. If it is empty, return an empty list. Nothing more to do here
    if (lists.isEmpty()) return emptyList()

    // Initialize our minimum heap. This will be usd to keep the lowest value from each list at the root of the heap.
    // Whenever a value is popped from the root, the next value is added to the heap and if it is the lowest value it
    // will be at the root of the heap
    val minHeap = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.first - b.first }

    // Iterate through the list storing only the first values from each list, including the list index and the element
    // and the element index which we will use to iterate through a given list. The list index will be used to iterate
    // through the provided lists
    for ((index, list) in lists.withIndex()) {
        if (list.isNotEmpty()) {
            val value = list[0]
            val elementIndex = 0
            minHeap.add(Triple(value, index, elementIndex))
        }
    }

    // result will store the final output
    val result = arrayListOf<Int>()

    // While we still have elements in the heap
    while (minHeap.isNotEmpty()) {
        // Get the top element from the heap
        val element = minHeap.poll()
        val value = element.first
        val listIndex = element.second
        val elementIndex = element.third
        // Add the value to the result, at this point we know this is the smallest value in the lists of lists
        result.add(value)

        // Check if the element index is less than the current list it an be found in. This means there are still other
        // elements within this list
        if(elementIndex + 1 < lists[listIndex].size) {
            val nextValue = lists[listIndex][elementIndex + 1]
            minHeap.add(Triple(nextValue, listIndex, elementIndex + 1))
        }
    }

    return result
}
