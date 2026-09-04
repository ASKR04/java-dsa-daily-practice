# Reverse Linked List

- Date: 2026-09-04
- Difficulty: Easy
- Topic: Linked List
- Pattern: Pointer reversal

## Problem

Given the head of a singly linked list, reverse the list and return the new head.

## Approach

Use three references while walking through the list:

1. `previous` tracks the reversed part of the list.
2. `current` tracks the node being processed.
3. `next` temporarily stores the original next node before the link is changed.
4. Point `current.next` back to `previous`.
5. Move `previous` and `current` forward.

When traversal finishes, `previous` is the new head.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
