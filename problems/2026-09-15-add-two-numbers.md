# Add Two Numbers

- Date: 2026-09-15
- Difficulty: Medium
- Topic: Linked List
- Pattern: Digit-by-digit simulation, carry

## Problem

Given two non-empty linked lists representing two non-negative integers, add the two numbers and return the sum as a linked list.

The digits are stored in reverse order, and each node contains a single digit.

## Approach

Simulate the same addition process used on paper from right to left. Because the linked lists already store digits in reverse order, each step adds the current nodes and carry.

1. Create a dummy node to build the result list.
2. Track a `carry` value while either input list still has nodes or a carry remains.
3. Read each current digit, using `0` when one list is shorter.
4. Append `sum % 10` to the result and update `carry` to `sum / 10`.
5. Move each input pointer forward when possible.

## Complexity

- Time: `O(max(m, n))`, where `m` and `n` are the lengths of the two lists.
- Space: `O(max(m, n))` for the result list.
