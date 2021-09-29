package com.kotlinground.puzzles.furthestbuilding

import java.util.PriorityQueue

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    if (heights.isEmpty() || heights.size == 1) {
        return 0
    }

    val priorityQueue = PriorityQueue<Int>()
    var currentBricks = bricks

    for (idx in 0 until heights.size - 1) {
        val diff = heights[idx + 1] - heights[idx]

        if (diff > 0) {
            priorityQueue.add(diff)
        }
        if (priorityQueue.size > ladders) {
            currentBricks -= priorityQueue.poll()
        }
        if (currentBricks < 0) {
            return idx
        }
    }
    return heights.size - 1
}
