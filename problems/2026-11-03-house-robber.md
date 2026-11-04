# House Robber

- Date: 2026-11-03
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Take-or-skip state transition

## Problem

Given the non-negative amount of money in each house along a street, return the maximum amount that can be collected without choosing two adjacent houses.

## Approach

At every house, compare two choices:

1. Rob the current house, which adds its value to the best result from two houses earlier.
2. Skip the current house, which keeps the best result from the previous house.
3. Store the larger choice as the best result through the current position.

Only the previous two dynamic-programming states are needed. The implementation uses `long` values so valid integer house amounts can be combined without overflowing an `int`.

## Complexity

- Time: `O(n)`.
- Space: `O(1)`.
