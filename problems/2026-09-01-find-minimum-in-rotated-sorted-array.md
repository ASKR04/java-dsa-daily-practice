# Find Minimum in Rotated Sorted Array

- Date: 2026-09-01
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Rotation pivot search

## Problem

Given a sorted array of distinct integers that has been rotated between `1` and `n` times, return the minimum element.

The solution should run in `O(log n)` time.

## Approach

Use binary search to locate the rotation pivot.

1. Keep `left` and `right` around the possible minimum.
2. Compare `nums[middle]` with `nums[right]`.
3. If `nums[middle] > nums[right]`, the minimum must be to the right of `middle`.
4. Otherwise, `middle` may be the minimum, so keep the left side including `middle`.
5. When `left == right`, that index holds the minimum value.

The rightmost value is a reliable reference because the array has distinct values.

## Complexity

- Time: `O(log n)`.
- Space: `O(1)`.
