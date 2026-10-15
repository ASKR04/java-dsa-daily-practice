# Kth Largest Element in a Stream

- Date: 2026-10-14
- Difficulty: Easy
- Topic: Heap / Priority Queue
- Pattern: Fixed-size min heap, streaming data

## Problem

Design a class that receives an initial collection of integers and supports adding values one at a time. After each addition, return the kth largest value seen so far.

## Approach

Maintain a min heap containing only the largest `k` values:

1. Add values directly while the heap contains fewer than `k` entries.
2. Once full, ignore a value when it is no larger than the heap minimum.
3. Otherwise, remove the minimum and insert the new value.
4. The heap minimum is always the kth largest value among all values seen.

Discarding smaller values keeps memory bounded regardless of stream length.

## Complexity

- Initialization: `O(n log k)` time.
- Each addition: `O(log k)` time.
- Space: `O(k)`.
