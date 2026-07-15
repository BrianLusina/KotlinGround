package com.kotlinground.datastructures.sets

/**
 * A minimal Union-Find data structure with path compression.
 */
class UnionFind(private val size: Int) {
    init {
        require(size >= 0) { "Expected $size to be greater than or equal to 0" }
    }

    private var parent = IntRange(0, size - 1).toMutableList()

    /**
     * Finds the representative (root) of the set containing element 'x'.
     */
    fun find(x: Int): Int {
        if (parent[x] != x) {
            // path compression
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    /**
     * Merges the sets containing elements 'x' and 'y'.
     * Returns True if a merge occurred, False if already in same set.
     */
    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX != rootY) {
            parent[rootY] = rootX
            return true
        }
        return false
    }
}
