# Maximum Average Subarray I

## Roadmap

- Level: Easy
- Topic: Sliding Window
- Pattern: Fixed-size window

## Problem

Given an integer array `nums` and an integer `k`, find the contiguous subarray of length `k` that has the maximum average value.

Return the maximum average.

## Approach

Build the sum of the first `k` values. Then slide the window one index at a time by adding the new rightmost value and removing the value that leaves on the left. Track the maximum window sum and divide it by `k` at the end.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- `k` equals `1`
- `k` equals the full array length
- Negative values
- Best average appears after the first window

