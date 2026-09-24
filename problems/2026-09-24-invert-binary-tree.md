# Invert Binary Tree

- Date: 2026-09-24
- Difficulty: Easy
- Topic: Binary Tree
- Pattern: Depth-first search, recursion

## Problem

Given the root of a binary tree, invert the tree by swapping the left and right children of every node. Return the root of the modified tree.

## Approach

Use recursive depth-first search:

1. Return `null` for an empty subtree.
2. Save the original left child.
3. Recursively invert the right subtree and assign it as the new left child.
4. Recursively invert the saved left subtree and assign it as the new right child.
5. Return the current node.

Each node is modified in place, so no second tree is required.

## Complexity

- Time: `O(n)`, because every node is visited once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
