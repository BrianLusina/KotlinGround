package com.kotlinground.datastructures.trees.binarytrees

import com.kotlinground.datastructures.trees.TreeNode

/**
 * Represents a node in a binary tree structure. Each node contains data, references to its left
 * and right child nodes, and additional properties such as depth, height, and degree. This class
 * extends the functionality provided by the [TreeNode] interface and implements specific logic for
 * binary trees.
 *
 * @param T The type of data held in the binary tree node.
 * @property data The actual data stored in the node.
 * @property left A reference to the left child node. It is `null` if no left child exists.
 * @property right A reference to the right child node. It is `null` if no right child exists.
 * @property depth Represents the depth of the node in the tree. Default is `null`.
 * @property height Represents the height of the node in the tree. Default is `null`.
 * @property degree Represents the degree of the node, which is determined by the number of children.
 * Default is `null`.
 * @property children A list containing the child nodes of the current node. This property dynamically
 * evaluates the presence of child nodes and returns them in an `ArrayList`. If both child nodes are
 * present, it returns both. If only one exists, it returns the existing child. If no children exist,
 * an empty list is returned.
 */
data class BinaryTreeNode<T>(
    override var data: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null,
    override var depth: Int? = null,
    override var height: Int? = null,
    override var degree: Int? = null,
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
