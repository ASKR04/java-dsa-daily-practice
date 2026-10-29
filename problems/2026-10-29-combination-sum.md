# Combination Sum

- Date: 2026-10-29
- Difficulty: Medium
- Topic: Backtracking
- Pattern: Reusable choices with pruning

## Problem

Given distinct positive candidate values and a non-negative target, return every unique combination whose values add to the target. Each candidate may be selected any number of times.

## Approach

Sort a copy of the candidates and build combinations in non-decreasing order:

1. Track the target amount that remains.
2. At each level, try candidates starting from the current index.
3. Reuse a candidate by passing its index into the recursive call.
4. Remove the latest choice after each call to explore the next branch.
5. Stop the loop when a candidate is larger than the remaining target.

Restricting later choices to the current index or beyond prevents different orderings of the same values from producing duplicate combinations.

## Complexity

- Time: Exponential in the target and number of candidates in the worst case.
- Space: `O(target / minCandidate)` auxiliary recursion depth, excluding the output.
