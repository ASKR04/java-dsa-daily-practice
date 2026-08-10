# Move Zeroes

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: Stable in-place partition

## Problem

Given an integer array `nums`, move all zeroes to the end while maintaining the relative order of the non-zero elements.

The operation must be done in-place.

## Approach

Use a write pointer to track where the next non-zero value should go. Scan the array once. When a non-zero value is found, write it at the write pointer and move the pointer forward. After all non-zero values are placed, fill the rest of the array with zeroes.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- Array has no zeroes
- Array has only zeroes
- Zeroes are already at the end
- Non-zero values must keep their original order

