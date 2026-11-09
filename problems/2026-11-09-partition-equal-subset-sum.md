# Partition Equal Subset Sum

- Date: 2026-11-09
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Reachable subset sums

## Problem

Given an array of non-negative integers, determine whether its values can be divided into two subsets with equal sums.

## Approach

An equal partition exists only when the total sum is even. In that case, search for a subset whose sum is half of the total:

1. Begin with zero as the only reachable sum.
2. For each number, keep every previously reachable sum.
3. Also add the current number to each reachable sum without exceeding the target.
4. Return immediately when the target becomes reachable.

The set of reachable sums is the dynamic-programming state. Building a new set for each number ensures that one array element cannot be selected more than once.

## Complexity

- Time: `O(n * target)` in the pseudo-polynomial worst case.
- Space: `O(target)` reachable sums.
