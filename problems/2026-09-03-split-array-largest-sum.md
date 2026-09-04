# Split Array Largest Sum

- Date: 2026-09-03
- Difficulty: Hard
- Topic: Binary Search
- Pattern: Minimum feasible answer

## Problem

Given an integer array `nums` and an integer `k`, split `nums` into `k` non-empty continuous subarrays.

Return the minimum possible largest sum among those subarrays.

## Approach

Binary search over the possible largest allowed subarray sum.

1. The smallest possible answer is the maximum single value, because every value must fit in some subarray.
2. The largest possible answer is the total sum, which represents using one subarray.
3. For a candidate largest sum, greedily scan from left to right and start a new subarray whenever adding the next value would exceed the candidate.
4. If the greedy split uses at most `k` subarrays, the candidate is feasible, so search lower.
5. Otherwise, the candidate is too small, so search higher.

This works because if a maximum subarray sum is feasible, every larger maximum is also feasible.

## Complexity

- Time: `O(n log s)`, where `n` is the array length and `s` is the range between max value and total sum.
- Space: `O(1)`.
