package com.kotlinground.design.smallestinfiniteset

import java.util.PriorityQueue

/**
 * Complexity Analysis
 *
 * Here, n is the number of add_back(num) calls and m is the number of pop_smallest() calls
 *
 * - Time Complexity O((m+n) * log(n))
 *   - In each pop_smallest() method call, in the worst case, we will need to remove a number from the hash set which
 *     will take O(1) time, and the top of the min-heap which will take O(log(n)) time. Thus, for m calls it will take
 *     O(m * log(n)) time.
 *
 *   - In each add_back(num) method call, we might push num in the hash set which will take O(1) time and min-heap
 *     which will take O(log(n)). Thus, for n calls it will take O(n * log(n)) time.
 *
 * - Space complexity: O(n)
 *   - In the worst case, we might add n elements in the hash set and the min-heap. Thus, it will take O(n) space
 */
class SmallestInfiniteSet {
    // stores the removed numbers added again
    private val elementSet = hashSetOf<Int>()

    // minimum heap priority queue to store the minimum number of all added numbers on the top
    private val addedElements = PriorityQueue<Int>()

    // variable initialized to 1 denoting the current minimum value in the set of all positive integers
    private var currentElement = 1

    fun popSmallest(): Int {
        val result: Int

        // if we have elements in the heap, the top element is removed and returned
        if (!addedElements.isEmpty()) {
            // pop the smallest element
            result = addedElements.poll()
            // remove it from the set
            elementSet.remove(result)
        } else {
            // the smallest element is the current element, we return it and set the current element to the next element
            result = currentElement
            currentElement += 1
        }

        return result
    }

    fun addBack(num: Int) {
        // if the num is greater than or equal to the current element, it is not added to the set, as it is greater than
        // our current element, this means that in the set of all positive integers, it already exists. Similarly, if it
        // is already in the element set, we do not add it as well as it might have been added before; this could be the
        // case where it is less than the current element.
        if (currentElement <= num || elementSet.contains(num)) {
            return
        }
        addedElements.add(num)
        elementSet.add(num)
    }
}