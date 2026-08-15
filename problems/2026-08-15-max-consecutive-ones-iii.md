# Max Consecutive Ones III

## Roadmap

- Level: Medium
- Topic: Sliding Window
- Pattern: Variable-size window with at most `k` invalid values

## Problem

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` zeroes.

## Approach

Use a sliding window that allows at most `k` zeroes. Expand the right pointer and count zeroes in the current window. If the zero count exceeds `k`, move the left pointer right until the window is valid again. Track the maximum valid window length.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- `k` is `0`
- All values are `1`
- All values are `0`
- Best window appears at the end

