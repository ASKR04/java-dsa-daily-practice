# Linked List Cycle

- Date: 2026-09-09
- Difficulty: Easy
- Topic: Linked List
- Pattern: Slow and fast pointers

## Problem

Given the head of a singly linked list, determine whether the list contains a cycle.

A cycle exists when a node's `next` reference points to an earlier node in the list.

## Approach

Use Floyd's cycle detection algorithm:

1. Start `slow` and `fast` at the head.
2. Move `slow` one node at a time.
3. Move `fast` two nodes at a time.
4. If the list has a cycle, the two pointers eventually meet.
5. If `fast` reaches the end, the list has no cycle.

This detects a cycle without modifying the list or using extra storage.

## Complexity

- Time: `O(n)`, where `n` is the number of reachable nodes.
- Space: `O(1)`.
