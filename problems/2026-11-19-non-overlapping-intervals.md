# Non-overlapping Intervals

- Date: 2026-11-19
- Difficulty: Medium
- Topic: Greedy, Intervals
- Pattern: Earliest finishing interval

## Problem

Given a collection of intervals, return the minimum number that must be removed
so every remaining pair is non-overlapping. Intervals that only touch at an
endpoint do not overlap.

## Approach

Sort a copy of the intervals by ending position and greedily keep the interval
that finishes earliest:

1. Accept the first interval and remember its ending position.
2. Remove each later interval whose start is before the remembered end.
3. Otherwise, accept that interval and update the remembered end.

The earliest finish leaves the most room for every future interval, maximizing
the number kept. Minimizing removals is equivalent to maximizing that set of
non-overlapping intervals. Sorting a copy preserves the caller's input order.

## Complexity

- Time: `O(n log n)`
- Space: `O(n)` for the copied intervals.
