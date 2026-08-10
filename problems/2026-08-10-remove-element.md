# Remove Element

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: In-place overwrite

## Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place.

Return the number of remaining elements `k`. The first `k` elements of `nums` must contain the values that are not equal to `val`. The order of the remaining elements can stay stable in this solution.

## Approach

Use a write pointer for the next valid position. Scan each value. When the value is not equal to `val`, write it at the write pointer and advance the pointer. Values beyond the returned length do not matter.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- Empty array
- Target value does not appear
- Every value equals the target
- Multiple target values appear consecutively

