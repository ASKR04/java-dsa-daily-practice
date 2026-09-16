# Rotate List

- Date: 2026-09-16
- Difficulty: Medium
- Topic: Linked List
- Pattern: Length counting, circular list break

## Problem

Given the head of a singly linked list and an integer `k`, rotate the list to the right by `k` places.

## Approach

First measure the list length and connect the tail back to the head to make a temporary cycle.

1. Return early for an empty list, one-node list, or `k == 0`.
2. Walk to the tail while counting the list length.
3. Reduce the rotation with `k % length`.
4. The new tail is `length - rotation - 1` steps from the current head.
5. The node after the new tail becomes the new head.
6. Break the cycle by setting `newTail.next` to `null`.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
