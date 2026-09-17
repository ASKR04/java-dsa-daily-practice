# Partition List

- Date: 2026-09-17
- Difficulty: Medium
- Topic: Linked List
- Pattern: Two dummy lists, stable partition

## Problem

Given the head of a linked list and a value `x`, partition it so that all nodes with values less than `x` come before nodes with values greater than or equal to `x`.

The relative order of nodes in each partition must stay the same.

## Approach

Build two chains while walking the original list: one for nodes less than `x`, and one for nodes greater than or equal to `x`.

1. Use `beforeDummy` and `afterDummy` to simplify appending.
2. Append each node to the correct chain.
3. Set `after.next` to `null` so the final list cannot retain stale links.
4. Attach the `before` chain to the start of the `after` chain.
5. Return `beforeDummy.next`.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)` extra space, excluding the reused list nodes.
