# Longest Increasing Subsequence

- Date: 2026-11-06
- Difficulty: Medium
- Topic: Dynamic Programming, Binary Search
- Pattern: Smallest tail for each subsequence length

## Problem

Given an integer array, return the length of its longest strictly increasing subsequence. A subsequence preserves the original order but may omit values.

## Approach

Maintain the smallest possible tail value for every increasing subsequence length found so far:

1. For each number, binary-search the current tails.
2. Find the first tail greater than or equal to the number.
3. Replace that tail, preserving more room for future values.
4. If no tail is large enough, append the number and increase the best length.

The tails array does not necessarily store an actual subsequence, but its populated length always equals the optimal subsequence length.

## Complexity

- Time: `O(n log n)`.
- Space: `O(n)`.
