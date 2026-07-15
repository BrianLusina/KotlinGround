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

    /**
     * Indicates whether the left link of a node is a thread in a threaded binary tree implementation.
     *
     * In a threaded binary tree, null pointers in leaf nodes or empty subtrees are replaced with
     * "threads" that point to the in-order predecessor or successor. This allows for more efficient
     * tree traversal without the need for a stack or recursion.
     *
     * @return `true` if the left link is a thread, `false` if it points to a child node, or `null`
     * if the state is undefined.
     */
    val leftThread: Boolean
        get() = false

    /**
     * Indicates whether the right child of the current node is threaded.
     *
     * In a threaded tree, threads are used to make in-order traversal more efficient by turning the
     * null pointers (usually indicating no left or right child) into pointers to the in-order predecessor
     * or successor. This variable signifies whether the right pointer of the node is a thread (true) or a
     * regular pointer to a right child (false). If null, the threading state is not specified or undefined.
     */
    val rightThread: Boolean
        get() = false

}
