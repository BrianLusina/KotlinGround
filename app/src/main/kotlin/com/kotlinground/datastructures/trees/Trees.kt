package com.kotlinground.datastructures.trees

abstract class Trees<TreeNode> {

    abstract fun insertTreeNode(data: Any): TreeNode?

    /**
     * Merge another tree into this tree
     * @param otherTree Root Node of other tree
     * @return New root to new merged tree
     */
    abstract fun mergeTree(root: TreeNode?, otherTree: TreeNode?): TreeNode?

    abstract fun inorderTraversalRecurse(root: TreeNode): Collection<Any>
    abstract fun inorderTraversalIteratively(): Collection<Any>
    abstract fun inorderMorrisTraversal(): Collection<Any>
    abstract fun preorderTraversal(): Collection<Any>
    abstract fun postorderTraversal(): Collection<Any>
}