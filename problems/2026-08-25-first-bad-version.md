# First Bad Version

- Date: 2026-08-25
- Difficulty: Easy
- Topic: Binary Search
- Pattern: First true predicate

## Problem

Given versions from `1` to `n`, find the first bad version. Once a version is bad, every later version is also bad.

The implementation receives a predicate that answers whether a version is bad. Return the smallest version number where the predicate is true.

## Approach

Use binary search over the version number range:

1. Keep `left` and `right` as the current possible range.
2. Check the middle version.
3. If the middle version is bad, the first bad version is at `middle` or to its left.
4. If the middle version is good, the first bad version must be to its right.
5. When the range collapses, `left` is the first bad version.

This is the standard first-true binary search pattern.

## Complexity

- Time: `O(log n)` predicate calls.
- Space: `O(1)`.
