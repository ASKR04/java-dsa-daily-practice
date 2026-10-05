# Kth Smallest Element in a BST

- Date: 2026-10-05
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Iterative inorder traversal

## Problem

Given the root of a binary search tree and a positive integer `k`, return the kth smallest node value.

## Approach

An inorder traversal of a binary search tree visits values in ascending order. Perform that traversal iteratively with a stack:

1. Push the current node and all of its left descendants.
2. Pop the next smallest node and decrement `k`.
3. Return its value when `k` reaches zero.
4. Continue from the popped node's right child.

The traversal stops after visiting the kth node instead of processing the entire tree. Invalid values of `k` produce an `IllegalArgumentException`.

## Complexity

- Time: `O(h + k)`, where `h` is the tree height.
- Space: `O(h)` for the traversal stack.
