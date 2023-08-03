package com.kotlinground.datastructures.trees.binarytrees.utils.generatetrees

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode

/**
 * Utility function that generates all unique binary trees with n nodes.
 */
fun generate(start: Int, end: Int): List<BinaryTreeNode?> {
    val bsts = mutableListOf<BinaryTreeNode?>()

    if (start > end) {
        bsts.add(null)
        return bsts
    }

    if (start == end) {
        bsts.add(BinaryTreeNode(start))
        return bsts
    }

    for (i in start..end) {
        val left = generate(start, i - 1)
        val right = generate(i + 1, end)

        for (l in left) {
            for (r in right) {
                val root = BinaryTreeNode(i)
                root.left = l
                root.right = r
                bsts.add(root)
            }
        }
    }

    return bsts
}

/**
 * Generate all unique binary trees with n nodes.
 */
fun generateTrees(n: Int): List<BinaryTreeNode?> {
    return generate(1, n)
}
