package com.kotlinground.datastructures.trees.binarytrees.avl

import com.kotlinground.datastructures.trees.TreeNode

/**
 * Represents a node in an AVL tree, which is a self-balancing binary search tree. Each node stores
 * data, references to its left and right child nodes, and additional properties such as height,
 * degree, and depth for tree operations.
 *
 * @param T The type of data held in the AVL tree node. The data type must implement [Comparator] for comparison purposes.
 * @property data The data stored in the node.
 * @property left Reference to the left child node. Defaults to `null` if there is no left child.
 * @property right Reference to the right child node. Defaults to `null` if there is no right child.
 * @property height The height of the node in the tree. The height is the number of edges on the longest path
 *                  from this node to a leaf. Defaults to `1` for leaf nodes.
 * @property degree The degree of the node. Represents the number of immediate children of the node. Defaults to `null`.
 * @property depth The depth of the node within the tree. Represents the number of edges from the root node
 *                 to this node. Defaults to `null`.
 * @property balanceFactor The balance factor of the node, calculated as the height difference between
 *                         the left and right child nodes. A balance factor within the range `-1` to `1`
 *                         indicates that the node is balanced.
 */
data class AVLTreeNode<T : Comparator<T>>(
    override var data: T,
    var left: AVLTreeNode<T>? = null,
    var right: AVLTreeNode<T>? = null,
    override var height: Int = 1,
    override var degree: Int? = null,
    override var depth: Int? = null
) : TreeNode<T> {

    val balanceFactor: Int
        get() = (left?.height ?: 0) - (right?.height ?: 0)
}
