# Maximum Depth of Binary Tree

- Date: 2026-09-22
- Difficulty: Easy
- Topic: Binary Tree
- Pattern: Depth-first search, recursion

## Problem

Given the root of a binary tree, return its maximum depth. The maximum depth is the number of nodes on the longest path from the root to a leaf.

## Approach

Use postorder depth-first search. An empty subtree has depth zero. For each non-empty node, recursively find the depth of both children and add one for the current node.

The recurrence is:

`depth(node) = 1 + max(depth(node.left), depth(node.right))`

## Complexity

- Time: `O(n)`, because each node is visited once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
