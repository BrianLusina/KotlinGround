package com.kotlinapp.datastructures.trees

sealed class TreeNode()

data class BinaryTreeNode(
    var data: Any,
    var left: BinaryTreeNode? = null,
    var right: BinaryTreeNode? = null
) : TreeNode()
