# Top K Frequent Elements

- Date: 2026-10-15
- Difficulty: Medium
- Topic: Heap / Priority Queue
- Pattern: Frequency map, bounded min heap

## Problem

Given an integer array and an integer `k`, return the `k` values that occur most frequently.

## Approach

Combine a hash map with a bounded min heap:

1. Count each value's occurrences in a frequency map.
2. Add each distinct value and its frequency to a min heap.
3. Whenever the heap grows beyond `k`, remove its least frequent entry.
4. Extract the remaining entries in reverse heap order to return the most frequent values first.

For equal frequencies, this implementation prefers smaller values so results are deterministic.

## Complexity

- Time: `O(n log k)`.
- Space: `O(n)` for the frequency map and `O(k)` for the heap.
