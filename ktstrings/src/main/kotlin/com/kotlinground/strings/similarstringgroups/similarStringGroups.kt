package com.kotlinground.strings.similarstringgroups

import com.kotlinground.datastructures.sets.UnionFind

fun numOfSimilarGroups(strs: List<String>): Int {
    val strsLength = strs.size
    if (strsLength == 0) {
        return 0
    }

    val unionFind = UnionFind(strsLength)

    for (x in 0 until strsLength) {
        for (y in x + 1 until strsLength) {
            if (areSimilar(strs[x], strs[y])) {
                unionFind.union(x, y)
            }
        }
    }

    val roots = IntRange(0, strsLength - 1)
        .map { unionFind.find(it) }
        .toList()

    return roots.size
}

fun areSimilar(s1: String, s2: String): Boolean {
    val diff = mutableListOf<Pair<Char, Char>>()
    val pairs = s1 zip s2
    for ((a, b) in pairs) {
        if (a != b) {
            diff.add(Pair(a, b))
            if (diff.size > 2) {
                return false
            }
        }
    }
    return false

//    return diff.isEmpty() || (diff.size == 2 && diff[0] == diff[1][::-1])
}
