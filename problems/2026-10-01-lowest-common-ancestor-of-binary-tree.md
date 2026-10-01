# Lowest Common Ancestor of a Binary Tree

- Date: 2026-10-01
- Difficulty: Medium
- Topic: Binary Tree
- Pattern: Postorder depth-first search

## Problem

Given a binary tree and references to two nodes in it, return their lowest common ancestor. The lowest common ancestor is the deepest node that has both targets in its subtree, where a node may be a descendant of itself.

## Approach

Use postorder recursion:

1. Return the current node when it is `null` or matches either target.
2. Search the left and right subtrees.
3. If both searches return a node, the targets were found on different sides, so the current node is their lowest common ancestor.
4. Otherwise, propagate the one non-null result upward.

Nodes are compared by identity because the requested targets are specific nodes, not values.

## Complexity

- Time: `O(n)` in the worst case.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
