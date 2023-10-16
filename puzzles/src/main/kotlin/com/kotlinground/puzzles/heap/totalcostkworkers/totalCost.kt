package com.kotlinground.puzzles.heap.totalcostkworkers

import java.util.PriorityQueue

fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    val headWorkers = PriorityQueue<Int>()
    val tailWorkers = PriorityQueue<Int>()

    // headWorkers stores the first k workers
    // tailWorkers stores at most k workers without any workers from the first k workers
    for (i in 0 until candidates) {
        headWorkers.add(costs[i])
    }

    for (i in maxOf(candidates, costs.size - candidates) until costs.size) {
        tailWorkers.add(costs[i])
    }

    var result = 0L
    var nextHead = candidates
    var nextTail = costs.size - 1 - candidates

    for (i in 0 until k) {
        if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
            result += headWorkers.poll()

            // only refill the queue if there are workers outside the 2 queues
            if (nextHead <= nextTail) {
                headWorkers.add(costs[nextHead])
                nextHead++
            }
        } else {
            result += tailWorkers.poll()
            // only refill the queue if there are workers outside the 2 queues
            if (nextHead <= nextTail) {
                tailWorkers.add(costs[nextTail])
                nextTail--
            }
        }
    }

    return result
}
