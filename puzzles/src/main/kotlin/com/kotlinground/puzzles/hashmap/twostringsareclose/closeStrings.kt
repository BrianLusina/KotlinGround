package com.kotlinground.puzzles.hashmap.twostringsareclose

fun closeStrings(word1: String, word2: String): Boolean {
    val map1 = word1.groupingBy { it }.eachCount()
    val map2 = word2.groupingBy { it }.eachCount()

    return map1.values.sorted() == map2.values.sorted() && map1.keys == map2.keys
}
