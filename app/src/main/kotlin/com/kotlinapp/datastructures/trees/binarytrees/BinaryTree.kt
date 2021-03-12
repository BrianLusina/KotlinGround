package com.kotlinapp.datastructures.trees.binarytrees

import com.kotlinapp.datastructures.trees.BinaryTreeNode
import com.kotlinapp.datastructures.trees.Trees

class BinaryTree(private val root: BinaryTreeNode? = null) : Trees<BinaryTreeNode>() {
    override fun addTreeNode(data: Any) {
        TODO("Not yet implemented")
    }

    override fun inorderTraversalRecurse(root: BinaryTreeNode): Collection<Any> {
        TODO("Not yet implemented")
    }

    override fun inorderTraversalIteratively(): Collection<Any> {
        val stack = arrayListOf<BinaryTreeNode>()
        val result = arrayListOf<Any>()
        var current = root;

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.add(current)
                current = current.left
            }

            current = stack.removeAt(stack.size - 1)
            result.add(current.data)
            current = current.right
        }

        return result
    }

    override fun inorderMorrisTraversal(): Collection<Any> {
        val result = arrayListOf<Any>()
        var current = root
        var pre: BinaryTreeNode?

        while (current != null) {
            if (current.left == null) {
                result.add(current.data)
                current = current.right
            }

            pre = current?.left

            while (pre?.right != null) {
                pre = pre.right
            }

            pre?.right = current
            val temp = current
            current = current?.left
            temp?.left = null
        }
        return result
    }

    override fun preorderTraversal(): Collection<Any> {
        val result = arrayListOf<Any>()
        val stack = arrayListOf<BinaryTreeNode>()

        if (root == null) {
            return result
        }

        var current = root

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                result.add(current.data)
                stack.add(current)
                current = current.left
            }

            current = stack.removeAt(stack.size - 1)
            current = current.right
        }

        return result
    }
}