# Min Cost Climbing Stairs

- Date: 2026-11-03
- Difficulty: Easy
- Topic: Dynamic Programming
- Pattern: Minimum-cost one-dimensional transition

## Problem

Each stair has a non-negative cost paid when that stair is used. Starting from stair zero or stair one, move one or two stairs at a time and return the minimum total cost needed to move beyond the final stair.

## Approach

For each destination step, there are two possible previous positions:

1. Move one step from the previous stair and pay that stair's cost.
2. Move two steps from the stair before it and pay that stair's cost.
3. Keep the smaller accumulated cost.

Only the previous two dynamic-programming values are needed, so the complete table can be reduced to two variables. A `long` result prevents overflow when many large integer costs are accumulated.

## Complexity

- Time: `O(n)`.
- Space: `O(1)`.
