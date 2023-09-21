package com.kotlinground.puzzles.search.binarysearch.snapshotarray

import java.util.TreeMap

/**
 * We wish to find the pos for the most recent value at the time we took the snapshot with the given snap_id, we are
 * trying to find the rightmost index in history=histories[i] such that the snap_id at history[pos] is less or equal
 * to the target snap_id (a[i][0] <= snap_id). This means that the feasible function is a[i][0] <= snap_id, whenever
 * this is true, we must check the positions on its right to find the rightmost position that makes this condition hold.
 *
 * Complexity Analysis, Let n be the maximum number of calls and k = length.
 *
 * Time complexity: O(nlog(n)+k)
 *     - We initialize histories with size k.
 *     - In the worst-case scenario, the number of calls to get, set, and snap are all O(n).
 *     - For each call to get(index, snap_id), we will perform a binary search over the list of records of nums[index].
 *         Since a list contains at most O(n) records, a binary search takes O(logn) time on average. Thus it requires
 *         O(nlogn) time.
 *     - Each call to snap takes O(1) time.
 *     - Each call to set(index, snap_id) appends a pair to the historical record of nums[index], which takes O(log(n))
 *      time since we are using a TreeMap
 *
 *  Space complexity: O(n+k)
 *      - We initialize historyRecords with size k.
 *      - We add one pair (snap_id, val) for each call to set, thus there are at most nnn pairs saved in histories
 */
class SnapshotArray(length: Int) {
    private var snapId = 0
    private val histories = Array<TreeMap<Int, Int>>(length) { TreeMap() }

    init {
        for (i in 0 until length) {
            histories[i] = TreeMap<Int, Int>()
            histories[i][0] = 0
        }
    }

    fun set(index: Int, data: Int) {
        histories[index][snapId] = data
    }

    fun snap(): Int {
        snapId += 1
        return snapId - 1
    }

    fun get(index: Int, snap_id: Int): Int {
        return histories[index].floorEntry(snap_id).value
    }
}
