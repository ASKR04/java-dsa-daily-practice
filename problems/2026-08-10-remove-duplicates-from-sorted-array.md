# Remove Duplicates from Sorted Array

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: In-place overwrite

## Problem

Given a sorted integer array `nums`, remove duplicate values in-place so each unique value appears once.

Return the number of unique values `k`. The first `k` elements of `nums` must contain the unique values in their original sorted order.

## Approach

Use a write pointer for the position of the next unique value. Scan from left to right. Whenever the current value differs from the previous value, write it at the write pointer and advance the pointer.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- Empty array
- Single-element array
- Array with no duplicates
- Array where all values are identical

