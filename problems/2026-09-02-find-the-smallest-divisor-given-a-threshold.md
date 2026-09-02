# Find the Smallest Divisor Given a Threshold

- Date: 2026-09-02
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Minimum feasible answer

## Problem

Given an integer array `nums` and an integer `threshold`, choose a positive integer divisor. Divide each value by the divisor, round each result up, and sum those rounded values.

Return the smallest divisor such that the sum is less than or equal to `threshold`.

## Approach

Binary search over possible divisors.

1. The smallest possible divisor is `1`.
2. The largest useful divisor is the maximum value in `nums`.
3. For a candidate divisor, compute the rounded-up sum using ceiling division.
4. If the sum is within the threshold, store the divisor and search for a smaller one.
5. Otherwise, search for a larger divisor.

This works because increasing the divisor never increases the rounded-up sum.

## Complexity

- Time: `O(n log m)`, where `n` is the number of values and `m` is the maximum value.
- Space: `O(1)`.
