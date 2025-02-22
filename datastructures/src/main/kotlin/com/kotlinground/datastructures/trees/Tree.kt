package com.kotlinground.datastructures.trees

abstract class Tree<T> {

    abstract fun insertTreeNode(data: T): TreeNode<T>?

    /**
     * Deletes a value from a tree
     */
    abstract fun delete(data: T): TreeNode<T>?

    /**
     * Merge another tree into this tree
     * @param otherTree Root Node of other tree
     * @return New root to new merged tree
     */
    abstract fun mergeTree(otherTree: TreeNode<T>?): TreeNode<T>?

    /**
     * Returns the height of a Tree or the maximum depth of the tree
     * A Tree's height is the number of links from its root to the furthest leaf
     * @return [Int]
     */
    abstract fun height(): Int

    /**
     * Returns the number of nodes of the tree
     * @return [Int]
     */
    abstract fun size(): Int

    abstract fun inorderTraversalIteratively(): Collection<T>

    abstract fun inorderMorrisTraversal(): Collection<T>

    abstract fun preorderTraversal(): Collection<T>

    abstract fun postorderTraversal(): Collection<T>

    /**
     * Performs a level order traversal of a tree returning a collection of data items on every node in the tree
     */
    abstract fun levelOrderTraversal(): Collection<T>

    abstract fun reverseLevelOrderTraversal(): Collection<T>

    /**
     * Finds the lowest common ancestor of 2 nodes in a Tree
     * @param nodeOne [TreeNode]
     * @param nodeTwo [TreeNode]
     * @return [TreeNode]
     */
    abstract fun lowestCommonAncestor(nodeOne: TreeNode<T>, nodeTwo: TreeNode<T>): TreeNode<T>?

    /**
     * Returns true if this tree has similar leaf value sequence to another tree.
     * For example: If this tree has nodes = [3,5,1,6,2,9,8,null,null,7,4] and other tree has nodes =
     * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]. Then the leaf value sequence of both is [6,7,4,9,8] which is
     * similar
     * @param other [Tree] Other tree to compare this tree to
     * @return boolean [Boolean] true if the leaves are similar, false otherwise.
     */
    abstract fun leafSimilar(other: Tree<T>): Boolean

    /**
     * Finds the number of good nodes in a tree. A good node is a node in which in the path from root to the node there
     * are no nodes with a value greater than it
     * @return [Int] The number of good nodes
     */
    abstract fun countGoodNodes(): Int

    abstract fun pathSum(target: Int): Int

    /**
     * Returns the smallest level x such that the sum of all the values of nodes at level x is maximal
     * Returns [Int] maximum value at level x
     */
    abstract fun maxLevelSum(): Int

    /**
     * Serializes a tree to a string
     */
    abstract fun serialize(): String

    /**
     * Deserializes a string to a  tree
     */
    abstract fun deserialize(tree: String): TreeNode<T>?
}
