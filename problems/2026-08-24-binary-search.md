# Binary Search

- Date: 2026-08-24
- Difficulty: Easy
- Topic: Binary Search
- Pattern: Search space halving

## Problem

Given a sorted array of integers `nums` and an integer `target`, return the index of `target` when it exists. Return `-1` when the target is not present.

## Approach

Use two pointers, `left` and `right`, to represent the current searchable range.

1. Start with the full array.
2. Compute the middle index without overflowing: `left + (right - left) / 2`.
3. If the middle value equals the target, return the middle index.
4. If the middle value is smaller than the target, search the right half.
5. If the middle value is larger than the target, search the left half.

Each step discards half of the remaining search space.

## Complexity

- Time: `O(log n)`, where `n` is the number of values.
- Space: `O(1)`.
