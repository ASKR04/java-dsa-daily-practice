# Construct BST from Preorder Traversal

- Date: 2026-10-07
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Preorder traversal, recursive bounds

## Problem

Given the preorder traversal of a binary search tree containing unique values, reconstruct the tree and return its root.

## Approach

Consume the preorder array once with a shared index and valid bounds for each subtree:

1. Inspect the next value without advancing the index.
2. Return an empty subtree when the value is outside the current open bounds.
3. Otherwise, consume the value and create the subtree root.
4. Build the left subtree within `(lower, value)`.
5. Build the right subtree within `(value, upper)`.

If values remain after constructing the root, the sequence was not a valid strict-BST preorder traversal.

## Complexity

- Time: `O(n)`, because each value is consumed once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
