# Merge Sorted Array

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: Reverse merge

## Problem

Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` as one sorted array.

The array `nums1` has length `m + n`, where the first `m` elements are valid and the last `n` elements are empty slots. The array `nums2` has length `n`.

## Approach

Use three pointers from the end:

- `left` points to the last valid element in `nums1`
- `right` points to the last element in `nums2`
- `write` points to the final position in `nums1`

Write the larger value into `nums1[write]`, then move the corresponding pointer backward. This avoids overwriting useful values in `nums1`.

## Complexity

- Time: `O(m + n)`
- Space: `O(1)`

## Edge Cases

- `nums2` is empty
- `nums1` has no initial valid values
- Duplicate values across both arrays
- All values in `nums2` are smaller than values in `nums1`

