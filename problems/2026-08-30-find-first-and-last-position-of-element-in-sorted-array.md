# Find First and Last Position of Element in Sorted Array

- Date: 2026-08-30
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Lower and upper bounds

## Problem

Given a sorted integer array `nums` and a `target`, return the starting and ending position of the target value. If the target does not exist, return `[-1, -1]`.

The solution should run in `O(log n)` time.

## Approach

Run binary search twice:

1. Find the first index where `nums[index] >= target`.
2. Find the first index where `nums[index] > target`.
3. The second position is one index before the upper bound.
4. If the lower bound is outside the array or does not point to the target, the target is missing.

This separates the boundary logic into reusable lower-bound searches.

## Complexity

- Time: `O(log n)`.
- Space: `O(1)`.
