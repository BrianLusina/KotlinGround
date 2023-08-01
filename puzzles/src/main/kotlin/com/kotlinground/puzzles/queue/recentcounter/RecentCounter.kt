package com.kotlinground.puzzles.queue.recentcounter

import java.util.LinkedList

class RecentCounter {
    private val slidingWindow = LinkedList<Int>()

    fun ping(t: Int): Int {
        slidingWindow.addLast(t)

        while (slidingWindow.first < t - 3000) {
            slidingWindow.removeFirst()
        }
        return slidingWindow.size
    }
}
