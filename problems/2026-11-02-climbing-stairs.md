# Climbing Stairs

- Date: 2026-11-02
- Difficulty: Easy
- Topic: Dynamic Programming
- Pattern: Fibonacci-style state transition

## Problem

Given a non-negative number of stairs, count how many distinct ways there are to reach the top when each move climbs either one or two stairs. The empty staircase has one valid way: take no steps.

## Approach

The final move onto stair `n` must come from stair `n - 1` or stair `n - 2`, so the number of ways follows this recurrence:

`ways(n) = ways(n - 1) + ways(n - 2)`

Keep only the previous two values instead of storing the complete dynamic-programming table. Start with one way to reach stair zero and one way to reach stair one, then advance the pair until the requested stair is reached.

The implementation returns a `long` and rejects inputs whose exact answer would exceed that type.

## Complexity

- Time: `O(n)`.
- Space: `O(1)`.
