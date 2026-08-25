# Search Insert Position

- Date: 2026-08-25
- Difficulty: Easy
- Topic: Binary Search
- Pattern: Lower bound

## Problem

Given a sorted array of distinct integers `nums` and a `target`, return the index where the target is found. If it is not found, return the index where it should be inserted to keep the array sorted.

## Approach

Use binary search to find the first index whose value is greater than or equal to the target.

1. Keep a half-open search range `[left, right)`.
2. Compute `middle` as `left + (right - left) / 2`.
3. If `nums[middle]` is less than the target, the insertion point must be to the right.
4. Otherwise, keep `middle` in the search space because it may be the answer.
5. When the range is empty, `left` is the insertion position.

This is the lower-bound form of binary search.

## Complexity

- Time: `O(log n)`, where `n` is the number of values.
- Space: `O(1)`.
