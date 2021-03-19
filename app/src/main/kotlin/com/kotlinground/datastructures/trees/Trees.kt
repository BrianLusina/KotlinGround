package com.kotlinground.datastructures.trees

abstract class Trees<TreeNode> {

    abstract fun insertTreeNode(data: Any): TreeNode?

    /**
     * Merge another tree into this tree
     * @param otherTree Root Node of other tree
     * @return New root to new merged tree
     */
    abstract fun mergeTree(root: TreeNode?, otherTree: TreeNode?): TreeNode?

    /**
     * Returns the height of a Tree or the maximum depth of the tree
     * A Tree's height is the number of links from its root to the furthest leaf
     * @return [Int]
     */
    abstract fun height(): Int

    abstract fun inorderTraversalRecurse(root: TreeNode): Collection<Any>
    abstract fun inorderTraversalIteratively(): Collection<Any>
    abstract fun inorderMorrisTraversal(): Collection<Any>
    abstract fun preorderTraversal(): Collection<Any>
    abstract fun postorderTraversal(): Collection<Any>
}