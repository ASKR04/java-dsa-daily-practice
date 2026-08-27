# Find Peak Element

- Date: 2026-08-27
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Slope-based search

## Problem

Given an integer array `nums`, find a peak element and return its index.

A peak element is greater than its neighbors. Treat values outside the array as negative infinity, so an edge value can be a peak.

## Approach

Use binary search on the array slope:

1. Compare `nums[middle]` with `nums[middle + 1]`.
2. If `nums[middle] < nums[middle + 1]`, a peak must exist on the right side.
3. Otherwise, a peak exists at `middle` or on the left side.
4. Shrink the search range until one index remains.

This works because moving uphill always eventually reaches a peak.

## Complexity

- Time: `O(log n)`.
- Space: `O(1)`.
