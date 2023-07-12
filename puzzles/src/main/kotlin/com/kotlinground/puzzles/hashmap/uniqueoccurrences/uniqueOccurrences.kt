package com.kotlinground.puzzles.hashmap.uniqueoccurrences


fun uniqueOccurrences(arr: IntArray): Boolean {
    val freqMap = hashMapOf<Int, Int>()

    for (num in arr) {
        freqMap[num] = freqMap.getOrDefault(num, 0) + 1;
    }

    // Store the frequency count of elements in the unordered set.
    val freqSet = HashSet<Int>(freqMap.values)

    // If the set size is equal to the map size,
    // It implies frequency counts are unique.
    return freqSet.size == freqMap.size
}
