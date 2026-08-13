# Contains Duplicate II

## Roadmap

- Level: Easy
- Topic: Sliding Window
- Pattern: Fixed-distance set

## Problem

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that:

- `nums[i] == nums[j]`
- `abs(i - j) <= k`

Return `false` otherwise.

## Approach

Maintain a sliding window of at most `k` previous values in a hash set. As each value is scanned, check whether it already exists in the window. If it does, a duplicate is close enough. Then add the current value and remove the value that falls outside distance `k`.

## Complexity

- Time: `O(n)`
- Space: `O(k)`

## Edge Cases

- `k` is `0`
- Duplicate exists but is too far apart
- Duplicate exists exactly `k` indices apart
- Negative values repeat

