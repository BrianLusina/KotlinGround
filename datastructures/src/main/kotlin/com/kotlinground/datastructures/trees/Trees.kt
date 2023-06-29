package com.kotlinground.datastructures.trees

abstract class Trees<T : Comparator<T>> {

    abstract fun insertTreeNode(data: T): TreeNode<T>?

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

    abstract fun inorderTraversalIteratively(): Collection<T>

    abstract fun inorderMorrisTraversal(): Collection<T>

    abstract fun preorderTraversal(): Collection<T>

    abstract fun postorderTraversal(): Collection<T>

    /**
     * Finds the lowest common ancestor of 2 nodes in a Tree
     * @param nodeOne [TreeNode]
     * @param nodeTwo [TreeNode]
     * @return [TreeNode]
     */
    abstract fun lowestCommonAncestor(nodeOne: TreeNode<T>, nodeTwo: TreeNode<T>): TreeNode<T>?
}
