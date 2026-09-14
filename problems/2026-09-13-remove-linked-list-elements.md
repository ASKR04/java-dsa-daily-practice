# Remove Linked List Elements

- Date: 2026-09-13
- Difficulty: Easy
- Topic: Linked List
- Pattern: Dummy node, pointer relinking

## Problem

Given the head of a singly linked list and an integer `val`, remove every node whose value equals `val`.

Return the head of the updated linked list.

## Approach

Use a dummy node before the head so removing the first node is handled the same way as removing any other node.

1. Point `dummy.next` to `head`.
2. Walk the list with a `current` pointer that always trails the node being inspected.
3. If `current.next.value` equals `val`, bypass that node.
4. Otherwise, move `current` forward.
5. Return `dummy.next`.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
