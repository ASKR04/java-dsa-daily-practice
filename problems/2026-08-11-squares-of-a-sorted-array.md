# Squares of a Sorted Array

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: Fill result from the end

## Problem

Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number, also sorted in non-decreasing order.

## Approach

Negative numbers can produce large squares, so the largest square is always at one of the two ends of the sorted input. Use two pointers at the start and end of `nums`, compare absolute values, and fill the result array from right to left.

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Edge Cases

- All negative values
- All non-negative values
- Mixed negative and positive values
- Zero in the input

