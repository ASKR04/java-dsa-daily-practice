# Linked List Cycle II

- Date: 2026-09-21
- Difficulty: Medium
- Topic: Linked List
- Pattern: Floyd's slow and fast pointers

## Problem

Given the head of a linked list, return the node where a cycle begins. Return `null` if the list has no cycle. Identify the node itself, not merely its value, and do not modify the list.

## Approach

Move one pointer one step and another pointer two steps until they meet or the faster pointer reaches the end. If they meet, place one pointer back at the head. Advance both one step at a time; their next meeting point is the cycle entry.

If the non-cyclic prefix has length `a`, the cycle has length `c`, and the meeting point is `b` steps past the entry, Floyd's meeting condition makes `a + b` a multiple of `c`. Walking `a` steps from the meeting point therefore reaches the entry at the same time as walking `a` steps from the head.

## Complexity

- Time: `O(n)`.
- Space: `O(1)`.
