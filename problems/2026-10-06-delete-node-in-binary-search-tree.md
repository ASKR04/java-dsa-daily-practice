# Delete Node in a Binary Search Tree

- Date: 2026-10-06
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Ordered recursion, inorder successor

## Problem

Given the root of a binary search tree and a key, delete the matching node if it exists and return the updated root while preserving BST ordering.

## Approach

First use the BST ordering to find the target. Once found, handle three structural cases:

1. With no left child, replace the node with its right child.
2. With no right child, replace the node with its left child.
3. With two children, promote the smallest node from the right subtree, remove it from its old position, and attach both remaining subtrees to it.

Promoting the inorder successor preserves all ordering relationships without changing node values.

## Complexity

- Time: `O(h)`, where `h` is the tree height.
- Space: `O(h)` for the recursion stack.
