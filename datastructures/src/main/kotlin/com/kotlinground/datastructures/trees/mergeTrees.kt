package com.kotlinground.datastructures.trees

import com.kotlinground.datastructures.trees.binarytrees.BinaryTreeNode

fun mergeTrees(root1: BinaryTreeNode<Int>?, root2: BinaryTreeNode<Int>?): BinaryTreeNode<Int>? {
    if (root1 == null) {
        return root2
    }

    if (root2 == null) {
        return root1
    }

    // assumption is that data is an integer
    root1.data += root2.data
    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)

    return root1
}
