# Daily Temperatures

- Date: 2026-08-20
- Difficulty: Medium
- Topic: Stack
- Pattern: Monotonic decreasing stack

## Problem

Given an array `temperatures`, return an array where each position contains the number of days until a warmer temperature. If there is no future warmer day, use `0`.

## Approach

Use a stack of indexes whose temperatures have not found a warmer future day yet.

1. Scan temperatures from left to right.
2. While the current temperature is warmer than the temperature at the index on top of the stack, pop that index.
3. The wait for the popped index is `currentIndex - poppedIndex`.
4. Push the current index because it may need a warmer day later.

The stack remains monotonic decreasing by temperature, which lets each index be pushed and popped at most once.

## Complexity

- Time: `O(n)`, where `n` is the number of temperatures.
- Space: `O(n)` for the stack and result array.
