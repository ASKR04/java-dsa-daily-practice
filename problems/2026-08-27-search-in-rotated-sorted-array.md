# Search in Rotated Sorted Array

- Date: 2026-08-27
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Sorted half detection

## Problem

Given a sorted array of distinct integers that has been rotated at an unknown pivot, return the index of `target`. Return `-1` when the target is not present.

The solution should run in `O(log n)` time.

## Approach

Use binary search while identifying which half is sorted.

1. Compute the middle index.
2. If the middle value is the target, return it.
3. If the left half is sorted, check whether the target belongs between `left` and `middle`.
4. Otherwise, the right half is sorted; check whether the target belongs between `middle` and `right`.
5. Discard the half that cannot contain the target.

The key is that at least one half is always sorted when the array contains distinct values.

## Complexity

- Time: `O(log n)`.
- Space: `O(1)`.
