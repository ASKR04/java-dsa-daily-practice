# Symmetric Tree

- Date: 2026-09-24
- Difficulty: Easy
- Topic: Binary Tree
- Pattern: Mirrored depth-first search

## Problem

Given the root of a binary tree, determine whether the tree is a mirror of itself around its center.

## Approach

Compare the root's left and right subtrees as mirrors:

1. If either node is `null`, the pair matches only when both are `null`.
2. The two node values must be equal.
3. Compare the outer pair: `left.left` with `right.right`.
4. Compare the inner pair: `left.right` with `right.left`.

An empty tree is symmetric.

## Complexity

- Time: `O(n)`, because each node is examined once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
