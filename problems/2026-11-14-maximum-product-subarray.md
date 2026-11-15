# Maximum Product Subarray

- Date: 2026-11-14
- Difficulty: Medium
- Topic: Dynamic Programming, Array
- Pattern: Track maximum and minimum ending products

## Problem

Given a non-empty integer array, return the largest possible product of a
non-empty contiguous subarray.

## Approach

A negative value can turn the smallest product ending at the previous position
into the largest product ending at the current position. Therefore, track both
extremes:

1. Swap the previous maximum and minimum when the current value is negative.
2. Either start a new subarray at the current value or extend each previous
   product.
3. Update the overall best result from the new maximum ending product.

Zeros naturally reset both states because starting again at zero is at least as
good as extending a product through it. The implementation uses exact `long`
multiplication so overflow is reported rather than silently wrapping.

## Complexity

- Time: `O(n)`
- Space: `O(1)`
