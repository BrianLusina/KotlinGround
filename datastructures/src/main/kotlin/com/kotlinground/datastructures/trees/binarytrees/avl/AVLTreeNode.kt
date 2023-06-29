package com.kotlinground.datastructures.trees.binarytrees.avl

import com.kotlinground.datastructures.trees.TreeNode

data class AVLTreeNode<T : Comparator<T>>(
    override var data: T,
    var left: AVLTreeNode<T>? = null,
    var right: AVLTreeNode<T>? = null,
    var height: Int = 1,
) : TreeNode<T> {

    val balanceFactor: Int
        get() = (left?.height ?: 0) - (right?.height ?: 0)
}
