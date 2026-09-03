# Peak Index in a Mountain Array

- Date: 2026-09-03
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Slope-based search

## Problem

Given a mountain array `arr`, return the index of the peak element.

A mountain array strictly increases up to one peak, then strictly decreases after it.

## Approach

Use binary search on the slope of adjacent values.

1. Compare `arr[middle]` with `arr[middle + 1]`.
2. If `arr[middle] < arr[middle + 1]`, the search is still climbing, so the peak is to the right.
3. Otherwise, the search is descending or at the peak, so keep `middle` and search left.
4. When `left == right`, that index is the peak.

This is a cleaner constrained version of the general peak-element search.

## Complexity

- Time: `O(log n)`.
- Space: `O(1)`.
