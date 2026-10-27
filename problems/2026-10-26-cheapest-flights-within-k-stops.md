# Cheapest Flights Within K Stops

- Date: 2026-10-26
- Difficulty: Medium
- Topic: Graph
- Pattern: Bounded Bellman-Ford relaxation

## Problem

Each directed flight `[departure, arrival, price]` connects cities labeled from `0` to `n - 1`. Return the cheapest price from a source to a destination using at most `k` intermediate stops, or `-1` if no valid route exists.

## Approach

A route with at most `k` stops uses at most `k + 1` flight edges. Run that many rounds of Bellman-Ford relaxation:

1. Set the source price to zero and every other price to infinity.
2. For each allowed edge count, clone the prices from the previous round.
3. Relax every flight using only the previous round's prices.
4. Store improvements in the cloned array for the next round.

Separating the current and next arrays prevents multiple flights from being chained during one round, so the stop limit is enforced correctly.

## Complexity

- Time: `O((K + 1) * E)` for the bounded relaxation rounds.
- Space: `O(V)` for the current and next price arrays.
