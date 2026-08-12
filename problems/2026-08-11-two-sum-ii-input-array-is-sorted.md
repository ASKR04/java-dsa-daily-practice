# Two Sum II - Input Array Is Sorted

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: Opposite-direction scan

## Problem

Given a 1-indexed sorted integer array `numbers` and a target value, return the indices of the two numbers that add up to the target.

Exactly one solution exists, and the same element cannot be used twice.

## Approach

Use one pointer at the beginning and one at the end. If the current sum is too small, move the left pointer right to increase the sum. If the current sum is too large, move the right pointer left to decrease the sum.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- Pair appears at the outermost positions
- Pair appears in the middle
- Negative values are present
- Duplicate values form the answer

