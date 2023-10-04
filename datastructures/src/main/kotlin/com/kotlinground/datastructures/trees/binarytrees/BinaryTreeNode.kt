package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.trees.TreeNode

data class BinaryTreeNode<T>(
    override var data: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null
) : TreeNode<T> {
    val children: ArrayList<BinaryTreeNode<T>?>
        get() {
            return if (left != null && right != null) {
                arrayListOf(left, right)
            } else if (left != null && right == null) {
                arrayListOf(left)
            } else if (left == null && right != null) {
                arrayListOf(right)
            } else {
                arrayListOf()
            }
        }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        other as BinaryTreeNode<*>

        return this.data == other.data
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }
}
