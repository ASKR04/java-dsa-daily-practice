# Reorder List

- Date: 2026-09-17
- Difficulty: Medium
- Topic: Linked List
- Pattern: Fast and slow pointers, reversal, alternating merge

## Problem

Given a singly linked list `L0 -> L1 -> ... -> Ln`, reorder it in place to `L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...`.

The node values must not be changed; only the links between nodes may be updated.

## Approach

Transform the list in three stages:

1. Find the end of the first half with slow and fast pointers.
2. Reverse the second half in place.
3. Disconnect the two halves to avoid a cycle.
4. Merge the halves by alternating one node from each side.

For `1 -> 2 -> 3 -> 4 -> 5`, the halves become `1 -> 2 -> 3` and `5 -> 4`, then merge into `1 -> 5 -> 2 -> 4 -> 3`.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
