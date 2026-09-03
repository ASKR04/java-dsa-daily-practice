# Minimum Number of Days to Make m Bouquets

- Date: 2026-09-02
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Minimum feasible answer

## Problem

Given an array `bloomDay`, where `bloomDay[i]` is the day the `i`th flower blooms, return the minimum day needed to make `m` bouquets. Each bouquet needs exactly `k` adjacent bloomed flowers.

If it is impossible to make `m` bouquets, return `-1`.

## Approach

Binary search over the answer day.

1. If `m * k` is greater than the number of flowers, return `-1`.
2. The earliest possible answer is the minimum bloom day.
3. The latest possible answer is the maximum bloom day.
4. For a candidate day, scan `bloomDay` and count adjacent bloomed flowers.
5. Every time `k` adjacent flowers are available, make one bouquet and reset the adjacent count.
6. If the candidate day can make enough bouquets, search earlier days. Otherwise, search later days.

This works because if a day is feasible, every later day is also feasible.

## Complexity

- Time: `O(n log r)`, where `n` is the number of flowers and `r` is the bloom-day range.
- Space: `O(1)`.
