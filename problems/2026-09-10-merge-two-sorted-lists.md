# Merge Two Sorted Lists

- Date: 2026-09-10
- Difficulty: Easy
- Topic: Linked List
- Pattern: Iterative merge with dummy node

## Problem

Given the heads of two sorted linked lists, merge them into one sorted linked list and return its head.

The merged list should reuse the original nodes.

## Approach

Use a dummy node to simplify list construction.

1. Keep a `tail` pointer at the end of the merged list.
2. Compare the current nodes from both lists.
3. Attach the smaller node to `tail.next`.
4. Advance the list that supplied the node.
5. After one list is exhausted, attach the remaining nodes from the other list.

The dummy node avoids special handling for the first merged node.

## Complexity

- Time: `O(n + m)`, where `n` and `m` are the lengths of the two lists.
- Space: `O(1)`.
