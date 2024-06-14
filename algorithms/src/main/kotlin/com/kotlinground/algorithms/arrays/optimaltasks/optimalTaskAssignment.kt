package com.kotlinground.algorithms.arrays.optimaltasks

/**
After sorting the array, the for loop iterates for half the length of the array adds the pairs using indexing to a
list. So ~x is the bitwise complement operator which puts a negative sign in front of x and subtracts 1 from it.
Thus, the negative numbers as indexes mean that you count from the right of the array instead of the left. So,
numbers[-1] refers to the last element, numbers[-2] is the second-last, and so on. In this way, we are able to pair
the numbers from the beginning of the array to the end of the array.
 **/
fun optimalTaskAssignment(tasks: List<Int>): List<Pair<Int, Int>> {
    val sortedTasks = tasks.sorted()
    val result = arrayListOf<Pair<Int, Int>>()

    for (index in 0 until sortedTasks.size / 2) {
        val first = sortedTasks[index]
        val second = sortedTasks[sortedTasks.size + index.inv()]
        result.add(Pair(first, second))
    }
    return result
}
