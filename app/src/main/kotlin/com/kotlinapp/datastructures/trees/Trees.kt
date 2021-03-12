package com.kotlinapp.datastructures.trees

abstract class Trees<TreeNode> {

    abstract fun addTreeNode(data: Any)

    abstract fun inorderTraversalRecurse(root: TreeNode): Collection<Any>
    abstract fun inorderTraversalIteratively(): Collection<Any>
    abstract fun inorderMorrisTraversal(): Collection<Any>
    abstract fun preorderTraversal(): Collection<Any>
    abstract fun postorderTraversal(): Collection<Any>
}