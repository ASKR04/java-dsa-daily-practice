# Middle of the Linked List

- Date: 2026-09-08
- Difficulty: Easy
- Topic: Linked List
- Pattern: Slow and fast pointers

## Problem

Given the head of a singly linked list, return the middle node.

If there are two middle nodes, return the second middle node.

## Approach

Use two pointers that move at different speeds:

1. Start both `slow` and `fast` at the head.
2. Move `slow` one node at a time.
3. Move `fast` two nodes at a time.
4. When `fast` reaches the end, `slow` is at the middle.

For even-length lists, this naturally returns the second middle node because `slow` advances once more before `fast` becomes `null`.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
