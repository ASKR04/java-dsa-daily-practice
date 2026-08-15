# Longest Substring Without Repeating Characters

## Roadmap

- Level: Medium
- Topic: Sliding Window
- Pattern: Variable-size window with last-seen index

## Problem

Given a string `s`, return the length of the longest substring that contains no repeated characters.

## Approach

Maintain a left boundary for the current window and a map from character to its most recent index. When a repeated character appears inside the current window, move the left boundary to one position after that previous occurrence. Track the maximum window length during the scan.

## Complexity

- Time: `O(n)`
- Space: `O(k)`, where `k` is the number of distinct characters in the current window

## Edge Cases

- Empty string
- All characters are identical
- Repeated character appears before the current window
- Longest substring appears at the end

