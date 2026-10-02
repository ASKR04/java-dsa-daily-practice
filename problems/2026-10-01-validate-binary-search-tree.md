# Validate Binary Search Tree

- Date: 2026-10-01
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Depth-first search, value bounds

## Problem

Given the root of a binary tree, determine whether it is a valid binary search tree. Every node in a left subtree must be strictly smaller than its ancestor, and every node in a right subtree must be strictly larger. Duplicate values are invalid.

## Approach

Carry the valid value range through a depth-first traversal:

1. Start the root with open bounds from negative infinity to positive infinity.
2. Reject a node when its value is not strictly inside its bounds.
3. The left child keeps the lower bound and uses the current value as its upper bound.
4. The right child uses the current value as its lower bound and keeps the upper bound.

Use `long` bounds so nodes containing `Integer.MIN_VALUE` or `Integer.MAX_VALUE` can still be validated correctly.

## Complexity

- Time: `O(n)`, because each node is visited once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
