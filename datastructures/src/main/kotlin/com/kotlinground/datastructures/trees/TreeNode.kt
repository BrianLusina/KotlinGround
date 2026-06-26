package com.kotlinground.datastructures.trees

import com.kotlinground.datastructures.linkedlists.generateKey

/**
 * Represents a node in a tree structure. Each node contains data and provides additional properties
 * such as a unique key, depth, and height.
 *
 * @param T The type of data held in the tree node.
 */
interface TreeNode<T> {
    var data: T
    val key: String?
        get() = lazy { generateKey(data) }
            .toString()

    /**
     * Represents the depth of a node in the tree.
     *
     * The depth of a node is defined as the number of edges or links from the tree's root
     * to the node. For the root node, the depth is 0. For other nodes, it increases incrementally
     * moving downward in the tree structure.
     *
     * @return The depth of the current node as an [Int], or `null` if the depth is not defined or cannot be determined.
     */
    val depth: Int?
        get() = null

    /**
     * Represents the height of a node in the tree.
     *
     * The height of a node is defined as the number of edges or links on the longest path
     * from the node to a leaf. A leaf node has a height of 0. For nodes that are not part
     * of a tree or whose height cannot be determined, the value will be `null`.
     *
     * @return The height of the current node as an [Int], or `null` if the height is undefined.
     */
    val height: Int?
        get() = null

    /**
     * Represents the degree of a node in a tree.
     *
     * The degree of a node is defined as the number of immediate child nodes it has.
     * In the context of a tree structure, this represents the branching factor
     * of the node. For a leaf node, the degree is `0`, while for internal nodes,
     * it is equal to the number of connected child nodes.
     *
     * @return The degree of the current node as an [Int], or `null` if the degree
     * cannot be determined or is undefined.
     */
    val degree: Int?
        get() = null

}
