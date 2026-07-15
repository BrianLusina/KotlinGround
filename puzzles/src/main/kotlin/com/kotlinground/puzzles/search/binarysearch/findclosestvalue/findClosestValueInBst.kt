package com.kotlinground.puzzles.search.binarysearch.findclosestvalue

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode
import kotlin.math.abs

fun findClosestValueInBst(node: BinaryTreeNode<Int>?, target: Int): Int {
    if (node == null) {
        return -1
    }

    if (node.data == target) return target

    var current: BinaryTreeNode<Int>? = node
    var closest = node.data
    var minDiff = abs(target - node.data)

    while (current != null) {
        val currentDiff = abs(target-current.data)
        if (currentDiff < minDiff) {
            minDiff = currentDiff
            closest = current.data
        }

        if (current.data == target) {
            return current.data
        }

        current = if (target < current.data) current.left else current.right
    }

    return closest
}
