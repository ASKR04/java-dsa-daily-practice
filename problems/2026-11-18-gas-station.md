# Gas Station

- Date: 2026-11-18
- Difficulty: Medium
- Topic: Greedy
- Pattern: Reset after an impossible prefix

## Problem

Gas stations form a circular route. At station `i`, `gas[i]` fuel is available
and `cost[i]` fuel is required to reach the next station. Starting with an empty
tank, return an index from which the complete circuit can be traveled, or `-1`
when no such index exists.

## Approach

Track both the route's total fuel balance and the balance from the current
candidate start:

1. Add each station's gas-minus-cost balance to both totals.
2. When the candidate balance becomes negative, no station from that candidate
   through the current station can be a valid start.
3. Reset the candidate to the next station and begin a new local balance.

A route is possible exactly when the total balance is non-negative. In that
case, the final candidate survives every remaining prefix and completes the
circuit. Running balances use `long` to avoid overflow for integer inputs.

## Complexity

- Time: `O(n)`
- Space: `O(1)`
