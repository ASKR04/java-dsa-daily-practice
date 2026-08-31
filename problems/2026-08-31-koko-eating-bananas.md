# Koko Eating Bananas

- Date: 2026-08-31
- Difficulty: Medium
- Topic: Binary Search
- Pattern: Minimum feasible answer

## Problem

Given banana piles and an integer `h`, find the minimum integer eating speed `k` such that all piles can be eaten within `h` hours.

In one hour, Koko chooses one pile and eats up to `k` bananas from it. If the pile has fewer than `k` bananas, she finishes it and does not eat from another pile during that hour.

## Approach

Binary search over the possible eating speed.

1. The slowest possible speed is `1`.
2. The fastest useful speed is the largest pile size.
3. For a candidate speed, compute the total required hours using ceiling division.
4. If the candidate can finish within `h`, store it and search lower speeds.
5. Otherwise, search higher speeds.

This is a minimum feasible answer search: once a speed works, every larger speed also works.

## Complexity

- Time: `O(n log m)`, where `n` is the number of piles and `m` is the largest pile.
- Space: `O(1)`.
