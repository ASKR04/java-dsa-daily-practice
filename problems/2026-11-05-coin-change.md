# Coin Change

- Date: 2026-11-05
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Unbounded minimum-count transition

## Problem

Given distinct positive coin denominations and a non-negative amount, return the minimum number of coins needed to form that amount. Each denomination may be used any number of times. Return `-1` when the amount cannot be formed.

## Approach

Use a one-dimensional dynamic-programming table where each index represents an amount:

1. Set the minimum coin count for amount zero to zero.
2. Initialize every other amount as unreachable.
3. For each amount, try every denomination that does not exceed it.
4. Add one coin to the best result for the remaining amount.
5. Keep the smallest candidate count.

Using `amount + 1` as the unreachable sentinel is safe because no valid answer can require more than `amount` positive-value coins.

## Complexity

- Time: `O(amount * numberOfCoins)`.
- Space: `O(amount)`.
