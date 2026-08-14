# Minimum Recolors to Get K Consecutive Black Blocks

## Roadmap

- Level: Easy
- Topic: Sliding Window
- Pattern: Fixed-size window count

## Problem

Given a string `blocks` containing only `B` and `W`, and an integer `k`, return the minimum number of white blocks that must be recolored so there are at least `k` consecutive black blocks.

## Approach

Every candidate group of `k` consecutive blocks is a fixed-size window. Count the number of white blocks in the first window, then slide the window by one position at a time. Remove the outgoing block from the count and add the incoming block. The answer is the minimum white count across all windows.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- First window is already all black
- Best window appears at the end
- Every block is white
- `k` equals the full string length

