package com.kotlinground.datastructures.timemap

class TimeMap {
    private val histories = hashMapOf<String, ArrayList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val timestampToValue = timestamp to value
        if (!histories.containsKey(key)) {
            histories[key] = arrayListOf(timestampToValue)
            return
        }
        histories[key]?.add(timestampToValue)
    }

    /**
     * To look for the location pos of the timestamp entry, we must find the timestamp pair less than or equal to
     * timestamp.
     * Hence, we repeatedly update pos to mid, if the timestamp at histories[mid] is less than or equal to the
     * given timestamp (histories[mid][0] <= timestamp),
     * to find the greatest timestamp less than or equal to timestamp.
     * In the binary search loop, we will continue to find the desired timestamp on the right side of the loop if
     * histories[mid][0] <= timestamp, and search the left side otherwise.
     */
    fun get(key: String, timestamp: Int): String {
        if (!histories.containsKey(key)) {
            return ""
        }

        val keyHistoricalValues = histories.getValue(key)

        var left = 0
        var right = keyHistoricalValues.size - 1
        var pos = -1

        while (left <= right) {
            val mid = left + (right - left) / 2

            val timestampValueAtMid = keyHistoricalValues[mid]
            val timestampForValue = timestampValueAtMid.first

            if (timestampForValue <= timestamp) {
                left = mid + 1
                pos = mid
            } else {
                right = mid - 1
            }
        }

        if (pos == -1) {
            return ""
        }

        return keyHistoricalValues[pos].second
    }
}