# Best Time to Buy and Sell Stock

## Roadmap

- Level: Easy
- Topic: Arrays
- Pattern: Track best value seen so far

## Problem

Given an array `prices` where `prices[i]` is the price of a stock on day `i`, choose one day to buy and a later day to sell.

Return the maximum possible profit. If no profitable trade exists, return `0`.

## Approach

Scan the prices from left to right while tracking the minimum price seen so far. For each day, calculate the profit if we sold on that day. Keep the maximum profit across all days.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- Prices always decrease
- Only one price exists
- Best buy day appears before the best sell day

