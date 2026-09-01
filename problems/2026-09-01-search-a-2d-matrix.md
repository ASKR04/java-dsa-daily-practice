# Search a 2D Matrix

- Date: 2026-09-01
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Flattened matrix search

## Problem

Given an `m x n` matrix where each row is sorted in ascending order and the first integer of each row is greater than the last integer of the previous row, determine whether `target` exists in the matrix.

## Approach

Treat the matrix as one sorted array without physically flattening it.

1. The virtual array has `rows * columns` values.
2. Binary search over virtual indexes from `0` to `rows * columns - 1`.
3. Convert a virtual index to matrix coordinates:
   - `row = index / columns`
   - `column = index % columns`
4. Compare the matrix value at those coordinates with the target.
5. Shrink the search range exactly like standard binary search.

This preserves `O(1)` extra space while using the sorted order across rows.

## Complexity

- Time: `O(log(m * n))`.
- Space: `O(1)`.
