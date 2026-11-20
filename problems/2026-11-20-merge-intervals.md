# Merge Intervals

- Date: 2026-11-20
- Difficulty: Medium
- Topic: Intervals
- Pattern: Sort and sweep

## Problem

Given a collection of closed intervals, combine every set of overlapping
intervals and return the resulting non-overlapping intervals in ascending
order. Intervals that meet at an endpoint are considered overlapping.

## Approach

Sort a copy of the intervals by starting position, then sweep from left to
right:

1. Keep the start and end of the current merged interval.
2. Extend its end when the next interval begins before or at the current end.
3. Otherwise, save the current interval and begin a new one.
4. Save the final interval after the scan.

Sorting ensures every interval that can overlap the current range appears
before the next disjoint range. Copying the input preserves the caller's order
and interval values.

## Complexity

- Time: `O(n log n)`
- Space: `O(n)` for sorting and the result.
