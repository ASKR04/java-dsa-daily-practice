# Last Stone Weight

- Date: 2026-10-14
- Difficulty: Easy
- Topic: Heap / Priority Queue
- Pattern: Max heap simulation

## Problem

Given an array of stone weights, repeatedly remove the two heaviest stones. Equal stones both disappear; otherwise, insert a new stone whose weight is their difference. Return the final weight, or zero when no stone remains.

## Approach

Use a max heap so the two heaviest stones are always available:

1. Add every positive stone weight to the heap.
2. Remove the two largest weights while at least two remain.
3. If they differ, add their difference back to the heap.
4. Return the remaining weight or zero.

Java's `PriorityQueue` is a min heap by default, so a reverse-order comparator turns it into a max heap.

## Complexity

- Time: `O(n log n)` in the worst case.
- Space: `O(n)` for the heap.
