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

---

## Maximum Level sum of a Binary Tree

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

```plain
Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
```

### Solution

#### Approach 1: Breadth First Search

The task is to compute the sum of all node values at each level to get the highest level with the maximum sum.

We can simply use a standard breadth-first search traversal because we need to analyze nodes by level.

BFS is an algorithm for traversing or searching a graph. It traverses in a level-wise manner, i.e., all the nodes at the
present level (say l) are explored before moving on to the nodes at the next level (l + 1). BFS is implemented with a
queue.

We initialize a queue of integers and an integer level = 0 to track the current level. In the queue, we push the root
node.

We perform a level-wise traversal, incrementing level by 1 each time when we move to a new level. At each iteration, we
remove all nodes at level, compute the sum of all node values at this level, and insert all their neighbouring nodes at
level + 1.

Because we are popping all of the nodes at level and inserting all of the nodes at level + 1, the size of the queue will
represent the number of nodes at the next level at the end of this iteration.

So we have two loops: the outer loop runs until the queue is empty, and the inner loop runs the number of times equal to
the size of the queue to just cover the nodes at the current level. We will pop all the nodes at level, compute the sum
of all the values, and insert all the nodes at level + 1 into the queue.

To get the answer, we compare the sum of all node values at the current level to the maximum sum of values we've already
seen. If the current sum of node values is greater than what we've seen before, we update our answer to level, and the
current sum becomes our largest sum of values seen thus far. Since we are traversing the higher levels first, by only
updating the answer when the level sum is greater than what we've seen before, we handle the tiebreakers automatically.

#### Complexity Analysis

##### Time Complexity O(n)

- Each queue operation in the BFS algorithm takes O(1) time, and a single node can only be pushed once, leading to
  O(n) operations for nnn nodes.
- The computation of sum of all the values of nodes at a level also takes O(n) time as each node's value is used
  once.

##### Space Complexity O(n)

- As the BFS queue stores the nodes in level-wise manner, the maximum number of nodes in the BFS queue would equal to
  the most number of nodes at any level. So, the best case would be O(1) where all the levels have just one node.
- The worst case would be a complete binary tree. In a complete binary tree, the last or second last level would have
  the most nodes (the last level can have multiple null nodes). Because we are iterating by level, the BFS queue will be
  most crowded when all of the nodes from the last level (or second last level) are in the queue. Assume we have a
  complete binary tree with height hhh and a fully filled last level having 2^h nodes. All the nodes at each level add
  up to 1+2+4+8+...+2^h=n. This implies that 2^{h + 1} - 1 = n and thus 2^h=(n+1)/2
  Because the last level h has 2^h nodes, the BFS queue will have (n+1)/2=O(n) elements in the worst-case scenario.

---