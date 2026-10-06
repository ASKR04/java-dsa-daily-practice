# Insert into a Binary Search Tree

- Date: 2026-10-06
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Ordered iterative descent

## Problem

Given the root of a binary search tree and a value not already present, insert a new node while preserving BST ordering and return the root.

## Approach

Follow one search path iteratively:

1. If the tree is empty, create and return the new root.
2. Move left when the value is smaller than the current node.
3. Move right when the value is larger.
4. When the required child is empty, attach the new node there and return the original root.

The implementation rejects duplicate values because this BST uses strict ordering.

## Complexity

- Time: `O(h)`, where `h` is the tree height.
- Space: `O(1)` because the traversal is iterative.
