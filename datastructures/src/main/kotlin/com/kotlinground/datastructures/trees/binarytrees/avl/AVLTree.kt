package com.kotlinground.datastructures.trees.binarytrees.avl

import com.kotlinground.datastructures.trees.TreeNode
import com.kotlinground.datastructures.trees.Tree
import com.kotlinground.datastructures.trees.compareTo

class AVLTree<T : Comparator<T>>(private var root: AVLTreeNode<T>? = null) : Tree<T>() {

    override fun insertTreeNode(data: T): TreeNode<T> {
        if (root == null) {
            root = AVLTreeNode(data)
            return root as AVLTreeNode<T>
        }

        fun insertNodeHelper(root: AVLTreeNode<T>?, data: T): AVLTreeNode<T> {
            if (root == null) {
                return AVLTreeNode(data)
            } else if (data < root.data) {
                root.left = insertNodeHelper(root.left, data)
            } else {
                root.right = insertNodeHelper(root.right, data)
            }

            root.height = 1 + maxOf(getHeight(root.left), getHeight(root.right))
            val balanceFactor = getBalanceFactorOfNode(root)

            if (balanceFactor > 1) {
                return if (data < root.left?.data) {
                    rightRotate(root)!!
                } else {
                    root.left = leftRotate(root.left)
                    rightRotate(root)!!
                }
            }

            if (balanceFactor < -1) {
                return if (data > root.right?.data) {
                    leftRotate(root)!!
                } else {
                    root.right = rightRotate(root.right)
                    leftRotate(root)!!
                }
            }

            return root
        }

        return insertNodeHelper(root, data)
    }

    override fun mergeTree(otherTree: TreeNode<T>?): TreeNode<T>? {
        TODO("Not yet implemented")
    }

    override fun delete(data: T): TreeNode<T>? {
        TODO("Not yet implemented")
    }

    override fun height(): Int {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun inorderTraversalIteratively(): Collection<T> {
        TODO("Not yet implemented")
    }

    override fun inorderMorrisTraversal(): Collection<T> {
        TODO("Not yet implemented")
    }

    override fun preorderTraversal(): Collection<T> {
        TODO("Not yet implemented")
    }

    override fun postorderTraversal(): Collection<T> {
        TODO("Not yet implemented")
    }

    override fun levelOrderTraversal(): Collection<T> {
        TODO("Not yet implemented")
    }

    override fun reverseLevelOrderTraversal(): Collection<T> {
        TODO("Not yet implemented")
    }

    override fun lowestCommonAncestor(nodeOne: TreeNode<T>, nodeTwo: TreeNode<T>): TreeNode<T>? {
        TODO("Not yet implemented")
    }

    private fun getHeight(root: AVLTreeNode<T>?): Int {
        if (root == null) {
            return 0
        }
        return root.height
    }

    private fun getBalanceFactorOfNode(root: AVLTreeNode<T>?): Int {
        if (root == null) {
            return 0
        }
        return getHeight(root.left) - getHeight(root.right)
    }

    private fun rightRotate(root: AVLTreeNode<T>?): AVLTreeNode<T>? {
        val y = root?.left
        val t3 = y?.right
        y?.right = root
        root?.left = t3
        root?.height = 1 + maxOf(getHeight(root?.left), getHeight(root?.right))
        y?.height = 1 + maxOf(getHeight(y?.left), getHeight(y?.right))
        return y
    }

    private fun leftRotate(root: AVLTreeNode<T>?): AVLTreeNode<T>? {
        val y = root?.right
        val t2 = y?.left
        y?.left = root
        root?.right = t2
        root?.height = 1 + maxOf(getHeight(root?.left), getHeight(root?.right))
        y?.height = 1 + maxOf(getHeight(y?.left), getHeight(y?.right))
        return y
    }

    override fun leafSimilar(other: Tree<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun countGoodNodes(): Int {
        TODO("Not yet implemented")
    }

    override fun pathSum(target: Int): Int {
        TODO("Not yet implemented")
    }

    override fun maxLevelSum(): Int {
        TODO("Not yet implemented")
    }

    override fun deserialize(tree: String): AVLTreeNode<T>? {
        TODO("Not yet implemented")
    }

    override fun serialize(): String {
        TODO("Not yet implemented")
    }
}
