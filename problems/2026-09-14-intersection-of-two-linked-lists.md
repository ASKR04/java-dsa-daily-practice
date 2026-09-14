# Intersection of Two Linked Lists

- Date: 2026-09-14
- Difficulty: Easy
- Topic: Linked List
- Pattern: Two pointers, pointer reset

## Problem

Given the heads of two singly linked lists, return the node where the two lists intersect.

The intersection is based on node identity, not node value. If the two linked lists do not intersect, return `null`.

## Approach

Use two pointers that walk both lists.

1. Start one pointer at `headA` and the other at `headB`.
2. Move each pointer one step at a time.
3. When a pointer reaches the end, redirect it to the head of the other list.
4. If the lists intersect, both pointers will meet at the shared node after traversing the same total distance.
5. If they do not intersect, both pointers eventually become `null`.

This avoids length calculation while keeping constant extra space.

## Complexity

- Time: `O(m + n)`, where `m` and `n` are the lengths of the two lists.
- Space: `O(1)`.
