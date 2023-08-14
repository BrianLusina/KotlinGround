package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.trees.TreeNode

data class BinaryTreeNode<T>(
    override var data: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null
) : TreeNode<T>
