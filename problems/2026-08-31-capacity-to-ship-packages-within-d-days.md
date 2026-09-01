# Capacity To Ship Packages Within D Days

- Date: 2026-08-31
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Minimum feasible answer

## Problem

Given package weights in conveyor order and an integer `days`, return the minimum ship capacity needed to ship all packages within `days` days.

Packages must be shipped in the given order. A ship can carry packages until adding the next package would exceed its capacity, then the next package starts the following day.

## Approach

Binary search over the possible ship capacity.

1. The minimum possible capacity is the heaviest single package.
2. The maximum needed capacity is the sum of all package weights.
3. For a candidate capacity, simulate loading packages in order and count required days.
4. If the candidate capacity can finish within `days`, store it and search lower capacities.
5. Otherwise, search higher capacities.

This works because once a capacity is feasible, every larger capacity is also feasible.

## Complexity

- Time: `O(n log s)`, where `n` is the number of packages and `s` is the range between the heaviest package and total weight.
- Space: `O(1)`.
