# Binary Tree Right Side View

- Date: 2026-09-30
- Difficulty: Medium
- Topic: Binary Tree
- Pattern: Right-first depth-first search, depth tracking

## Problem

Given the root of a binary tree, return the values visible when the tree is viewed from the right side, ordered from top to bottom.

## Approach

Traverse the tree with right-first depth-first search:

1. Track the current depth.
2. When the depth equals the result size, this is the first node visited at that level, so add it.
3. Visit the right child before the left child.

The first node reached at each depth is therefore the rightmost available node. A left-side node is still selected when no node farther right exists at that level.

## Complexity

- Time: `O(n)`, because every node is visited once.
- Space: `O(h)` for the recursion stack, excluding the output, where `h` is the tree height.
