# Odd Even Linked List

- Date: 2026-09-14
- Difficulty: Medium
- Topic: Linked List
- Pattern: Pointer relinking, stable partition

## Problem

Given the head of a singly linked list, group all nodes at odd indices together followed by all nodes at even indices.

The first node is considered odd, the second node is even, and so on. The relative order inside the odd group and even group must stay the same.

## Approach

Keep two chains while walking the list: one for odd-indexed nodes and one for even-indexed nodes.

1. Store the first even node as `evenHead`.
2. Move `odd.next` to the next odd node.
3. Move `even.next` to the next even node.
4. Continue until there are no more even nodes to process.
5. Attach the end of the odd chain to `evenHead`.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
