# Lowest Common Ancestor of a BST

- Date: 2026-10-05
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Ordered iterative search

## Problem

Given a binary search tree and two nodes in it, return their lowest common ancestor. A node may be a descendant of itself.

## Approach

Use the BST ordering to follow only one path:

1. If both target values are smaller than the current value, move left.
2. If both target values are larger than the current value, move right.
3. Otherwise, the targets split across the current node, or the current node is one target, so it is the lowest common ancestor.

This avoids searching both subtrees as required in a general binary tree.

## Complexity

- Time: `O(h)`, where `h` is the tree height.
- Space: `O(1)` because the search is iterative.
