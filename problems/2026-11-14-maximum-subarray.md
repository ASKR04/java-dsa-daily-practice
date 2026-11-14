# Maximum Subarray

- Date: 2026-11-14
- Difficulty: Medium
- Topic: Dynamic Programming, Array
- Pattern: Kadane's algorithm

## Problem

Given a non-empty integer array, return the largest possible sum of a non-empty
contiguous subarray.

## Approach

At each position, the best subarray ending there has two choices:

1. Start a new subarray with the current value.
2. Extend the best subarray that ended at the previous position.

Keep the larger choice as the current state and update the best sum seen over
all ending positions. Starting from the first value ensures arrays containing
only negative values still return their largest element. The implementation
uses `long` for running sums so valid integer inputs do not overflow.

## Complexity

- Time: `O(n)`
- Space: `O(1)`
