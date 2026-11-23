# Insert Interval

- Date: 2026-11-23
- Difficulty: Medium
- Topic: Intervals
- Pattern: Linear merge into sorted intervals

## Problem

Given sorted, non-overlapping closed intervals and one new closed interval,
insert the new interval in order and merge every overlap. Return the resulting
sorted, non-overlapping intervals.

## Approach

The existing order allows the result to be built in one pass:

1. Copy every interval that ends before the new interval begins.
2. Merge every interval whose start is at or before the growing merged end.
3. Append the merged interval.
4. Copy the remaining intervals, which all begin after the merged end.

Cloning copied intervals preserves both the caller's top-level array and each
nested interval array.

## Complexity

- Time: `O(n)`
- Space: `O(n)` for the returned intervals.
