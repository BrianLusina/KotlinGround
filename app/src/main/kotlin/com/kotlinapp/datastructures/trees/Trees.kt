package com.kotlinapp.datastructures.trees

abstract class Trees<TreeNode> {

    abstract fun addTreeNode(data: Any)

    abstract fun inorderTraversalRecurse(root: TreeNode): Collection<Any>
    abstract fun inorderTraversalIteratively(): Collection<Any>
    abstract fun inorderMorrisTraversal(): Collection<Any>
}