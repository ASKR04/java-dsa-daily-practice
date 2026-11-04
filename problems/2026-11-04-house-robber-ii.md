# House Robber II

- Date: 2026-11-04
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Circular take-or-skip transition

## Problem

Given the non-negative amount of money in each house arranged in a circle, return the maximum amount that can be collected without choosing two adjacent houses. The first and last houses are adjacent.

## Approach

The circular conflict means a valid solution cannot contain both the first and last houses. Split the problem into two linear cases:

1. Find the best result while excluding the last house.
2. Find the best result while excluding the first house.
3. Return the larger result.

Each linear range uses the House Robber take-or-skip transition with only two previous states. A `long` result allows multiple large integer house values to be combined safely.

## Complexity

- Time: `O(n)`.
- Space: `O(1)`.
