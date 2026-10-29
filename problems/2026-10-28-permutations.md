# Permutations

- Date: 2026-10-28
- Difficulty: Medium
- Topic: Backtracking
- Pattern: In-place choice and undo

## Problem

Given an array of distinct integers, return every possible ordering of its values. The permutations may be returned in any order.

## Approach

Build each permutation from left to right using backtracking:

1. Treat the current index as the position to fill.
2. Swap each remaining candidate into that position.
3. Recurse to fill the next position.
4. Swap the values back so the next branch starts from the previous state.
5. When all positions are fixed, copy the working array into the result.

The method clones the input before backtracking so callers never observe the temporary swaps.

## Complexity

- Time: `O(n * n!)` because there are `n!` permutations and copying one takes `O(n)`.
- Space: `O(n * n!)` for the output and `O(n)` auxiliary recursion depth.
