package com.kotlinground.puzzles.search.binarysearch.platesbetweencandles

fun platesBetweenCandles(platesAndCandles: String, queries: Array<IntArray>): IntArray {
    // This will hold the indices of candles in the plates and candles
    // This allows us to do basic arithmetic on the indices to find the number of plates.
    // Also, we perform a binary search on this candle list.
    // We find the left_pos and right_pos indicating the outside candles positions in the input.
    // Then, We know that the number of plates is given by the interval between the two
    // bounding candles subtracted by the number of candles in between.
    // With the indices left_pos and right_pos, we can
    // derive the number of plates to be (candles[right_pos] - candles[left_pos]) - (right_pos - left_pos).
    // Space complexity is O(c) where c is the number of candles.
    // The worst case is that there are all candles.
    val candles = arrayListOf<Int>()

    // Adds all candle indices on the table to the candle list.
    // Time Complexity is O(n) where n is the number of candles and plates. We have to scan over all plates and candles
    // to check which is a candle before adding its index.
    for (index in platesAndCandles.indices) {
        if (platesAndCandles[index] == '|') {
            candles.add(index)
        }
    }

    // our result list will store answers to each query
    val result = arrayListOf<Int>()

    for ((qLeft, qRight) in queries) {
        var leftPos = -1
        var rightPos = -1

        // 1. find the index of the first candle that comes after q_left
        // the index left_pos in candles of the first candle that is greater than q_left means that whenever
        // candles[index] >= q_left, we can update left_pos until we find the leftmost index at candles[index] >= q_left
        // (recurse on left-half).
        var left = 0
        var right = candles.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (candles[mid] >= qLeft) {
                right = mid - 1
                leftPos = mid
            } else {
                left = mid + 1
            }
        }

        // 2. Find the index of the last candle that comes before q_right
        // The index right_pos in candles of the last candle that is smaller than q_right means that whenever
        // candles[index] <= q_right, we can update right_pos until we find the rightmost index
        // at candles[index] >= q_right (recurse on right-half).
        left = 0
        right = candles.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2

            if (candles[mid] <= qRight) {
                left = mid + 1
                rightPos = mid
            } else {
                right = mid - 1
            }
        }

        // result = range between two outermost candles - candle count in between
        if (rightPos != -1 && leftPos != -1 && rightPos >= leftPos) {
            val numberOfPlates = candles[rightPos] - candles[leftPos] - (rightPos - leftPos)
            result.add(numberOfPlates)
        } else {
            result.add(0)
        }
    }

    return result.toIntArray()
}
