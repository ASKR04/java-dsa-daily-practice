# Minimum Size Subarray Sum

## Roadmap

- Level: Medium
- Topic: Sliding Window
- Pattern: Variable-size window

## Problem

Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a contiguous subarray whose sum is greater than or equal to `target`.

Return `0` if no such subarray exists.

## Approach

Use a sliding window with two pointers. Expand the right pointer to increase the sum. Whenever the sum reaches or exceeds `target`, update the best length and shrink from the left to find a smaller valid window.

This works because all values are positive, so removing values from the left can only decrease the sum.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- No valid subarray exists
- A single value meets the target
- The full array is the minimum valid window
- Multiple valid windows exist

