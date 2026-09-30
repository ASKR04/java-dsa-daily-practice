# Diameter of Binary Tree

- Date: 2026-09-29
- Difficulty: Medium
- Topic: Binary Tree
- Pattern: Postorder depth-first search, global optimum

## Problem

Given the root of a binary tree, return the length of its diameter. The diameter is the longest path between any two nodes and is measured by its number of edges. The path does not need to pass through the root.

## Approach

Use a postorder traversal that calculates subtree heights while updating the best diameter:

1. An empty subtree has height zero.
2. Recursively calculate the left and right subtree heights.
3. A path passing through the current node uses `leftHeight + rightHeight` edges.
4. Update the maximum diameter with that candidate.
5. Return one plus the larger child height to the parent.

Checking every node is important because the longest path may lie entirely inside one subtree.

## Complexity

- Time: `O(n)`, because each node is visited once.
- Space: `O(h)` for the recursion stack, where `h` is the tree height.
