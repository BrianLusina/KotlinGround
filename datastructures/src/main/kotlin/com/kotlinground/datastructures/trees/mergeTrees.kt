package com.kotlinground.datastructures.trees

fun mergeTrees(root1: BinaryTreeNode?, root2: BinaryTreeNode?): BinaryTreeNode? {
    if (root1 == null) {
        return root2
    }

    if (root2 == null) {
        return root1
    }

    // assumption is that data is an integer
    root1.data += root2.data as Int
    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)

    return root1
}

private operator fun Any.plusAssign(i: Int) {
    this += i
}
