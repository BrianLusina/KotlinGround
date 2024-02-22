package com.kotlinground.datastructures.hashset

class MyHashSet() {

    /** Initialize your data structure here. */
    var hash = HashSet<Int>()

    fun add(key: Int) {
        if (!contains(key)) {
            hash.add(key)
        }
    }

    fun remove(key: Int) {
        if (contains(key)) {
            hash.remove(key)
        }
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        return hash.contains(key)
    }
}