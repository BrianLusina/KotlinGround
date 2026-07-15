package com.kotlinground.algorithms.intervals.taskscheduler

import kotlin.math.max

fun leastIntervalsMathematical(tasks: List<String>, n: Int): Int {
    // get the total number of tasks
    val totalTasks = tasks.size

    // get all frequencies of tasks
    val taskCountMap = hashMapOf<String, Int>()
    for (task in tasks) {
        if (taskCountMap.containsKey(task)) {
            val taskCount = taskCountMap.get(task)
            taskCountMap[task] = taskCount!! + 1
        } else {
            taskCountMap[task] = 1
        }
    }

    // get the maximum frequency task from the taskCount
    var maxFreq = 0
    for (taskEntry in taskCountMap.entries) {
        maxFreq = max(taskEntry.value, maxFreq)
    }

    // Calculate how many tasks share the max frequency
    // This is slightly more efficient than looping through the full dictionary
    //  because it stops checking once frequencies drop below max_freq
    val maxFreqCount = taskCountMap.values
        .filter { it == maxFreq }
        .map { 1 }
        .sum()

    // Calculate the least number of intervals
    val result = (maxFreq - 1) * (n + 1) + maxFreqCount

    return max(result, totalTasks)
}

// TODO: implement using max heap
fun leastIntervalsMaxHeap(tasks: List<String>, n: Int): Int {
    return 0
}
