# Balanced Binary Tree

- Date: 2026-09-27
- Difficulty: Easy
- Topic: Binary Tree
- Pattern: Postorder depth-first search, sentinel value

## Problem

Given the root of a binary tree, determine whether it is height-balanced. A tree is height-balanced when the heights of the left and right subtrees of every node differ by at most one.

## Approach

Use one postorder traversal that returns a subtree's height or `-1` when the subtree is already unbalanced.

1. An empty subtree has height zero.
2. Recursively calculate the left height; immediately propagate `-1` if needed.
3. Calculate the right height and compare the two heights.
4. Return `-1` when their difference exceeds one; otherwise return the current height.

This combines balance checking and height calculation, avoiding repeated height traversals.

## Complexity

- Time: `O(n)`, because each node is visited once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
