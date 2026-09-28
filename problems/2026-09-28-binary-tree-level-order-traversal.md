# Binary Tree Level Order Traversal

- Date: 2026-09-28
- Difficulty: Medium
- Topic: Binary Tree
- Pattern: Breadth-first search, queue

## Problem

Given the root of a binary tree, return its node values level by level from left to right.

## Approach

Use breadth-first search with a queue:

1. Add the root to the queue.
2. At the start of each iteration, record the current queue size. Those nodes form one complete level.
3. Remove exactly that many nodes, append their values to the current level, and enqueue their non-null children.
4. Add the completed level to the result.

Recording the level size before processing prevents newly added children from mixing with their parents' level.

## Complexity

- Time: `O(n)`, because every node is enqueued and removed once.
- Space: `O(w)`, where `w` is the maximum number of nodes on one level, excluding the output.
