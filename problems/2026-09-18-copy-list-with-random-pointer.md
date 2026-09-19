# Copy List with Random Pointer

- Date: 2026-09-18
- Difficulty: Medium
- Topic: Linked List
- Pattern: Node interleaving, deep copy

## Problem

Each node in a linked list has a `next` pointer and a `random` pointer that may refer to any node in the list or to `null`.

Create a deep copy in which every copied pointer refers only to copied nodes. Leave the original list unchanged.

## Approach

Temporarily interleave each copied node directly after its original node.

1. Insert a copy after every original node.
2. For each original node, assign the copy's random pointer using `original.random.next`.
3. Separate the interleaved structure into the restored original list and the copied list.

Placing each copy beside its original provides a direct mapping without a hash map.

## Complexity

- Time: `O(n)`, using three passes through the list.
- Space: `O(1)` auxiliary space, excluding the required copied nodes.
