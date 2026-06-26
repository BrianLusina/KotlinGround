package com.kotlinground.datastructures.unionfind

class UnionFind(private val size: Int) {
    private var count = size
    private val id = IntArray(size)
    init {
        require(size >= 0) { "Expected $size to be greater than or equal to 0" }
        for (i in 0 until size) {
            id[i] = i
        }
    }

    /**
     * Adds a connection between p and q
     */
    fun union(p: Int, q: Int) {

    }

    /**
     * Component identifier for p
     */
    fun find(p: Int): Int {
        return 0
    }

    /**
     * Component identifier for p using Quick-Find
     */
    fun quickFind(p: Int): Int {
        return id[p]
    }

    /**
     * Adds a connection between p and q using Quick-Find
     */
    fun quickUnion(p: Int, q: Int) {
        val pId = find(p)
        val qId = find(q)
        // Nothing to do here, if p and q are already in the same component
        if (pId == qId) return
        for (i in 0 until id.size) {
            if (id[i] == qId) {
                id[i] = qId
            }
        }
        count--
    }

    /**
     * Return true if p and q are in the same component
     */
    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    /**
     * Return the number of components
     */
    fun count(): Int {
        return count
    }
}
