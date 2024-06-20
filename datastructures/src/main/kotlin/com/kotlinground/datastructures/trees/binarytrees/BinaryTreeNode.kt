package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.trees.TreeNode

data class BinaryTreeNode<T>(
    override var data: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null
) : TreeNode<T> {
    val children: ArrayList<BinaryTreeNode<T>?>
        get() {
            return when {
                left != null && right != null -> {
                    arrayListOf(left, right)
                }

                left != null && right == null -> {
                    arrayListOf(left)
                }

                left == null && right != null -> {
                    arrayListOf(right)
                }

                else -> arrayListOf()
            }
        }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        other as BinaryTreeNode<*>

        return this.key == other.key
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }
}
