# Next Greater Element I

- Date: 2026-08-19
- Difficulty: Easy
- Topic: Stack, Hash Map
- Pattern: Monotonic decreasing stack

## Problem

Given two arrays `nums1` and `nums2`, where every value in `nums1` appears in `nums2`, return the next greater element for each value in `nums1`.

The next greater element of a value is the first greater value that appears to its right in `nums2`. If no such value exists, use `-1`.

## Approach

Scan `nums2` from left to right with a monotonic decreasing stack:

1. Keep values on the stack while they have not found a greater value yet.
2. When the current value is greater than the stack top, it is the next greater element for that top value.
3. Pop resolved values and store their next greater value in a map.
4. Push the current value onto the stack.
5. Build the answer for `nums1` from the map, defaulting to `-1`.

This pattern avoids checking every pair manually.

## Complexity

- Time: `O(n + m)`, where `n` is `nums2.length` and `m` is `nums1.length`.
- Space: `O(n)` for the stack and map.
