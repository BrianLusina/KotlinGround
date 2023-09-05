# Binary Trees

Contains Binary tree implementation in Kotlin

---

## Leaf-Similar Trees

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value
sequence.

For example, in the given tree [3,5,1,6,2,9,8,null,null,7,4], the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

```plain
Example:

Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
```

```plain
Example:

Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
```

### Approach 1: Depth First Search

#### Intuition and Algorithm

Let's find the leaf value sequence for both given trees. Afterwards, we can compare them to see if they are equal or
not.

To find the leaf value sequence of a tree, we use a depth first search. Our dfs function writes the node's value if it
is a leaf, and then recursively explores each child. This is guaranteed to visit each leaf in left-to-right order, as
left-children are fully explored before right-children.

#### Complexity Analysis

1. `Time Complexity: O(T1+T2)` where T1, T2, are the lengths of the given trees.
2. `Space Complexity: O(T1+T2)`, the space used in storing the leaf values.

### Related Topics

- Tree
- Depth-First Search
- Binary Tree

---

## Path Sum

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along
the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent
nodes to child nodes).

```plain
Example 1
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3

Example 2:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
```

### Related Topics

- Tree
- Depth First Search
- Binary Tree