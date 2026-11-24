# Interval List Intersections

- Date: 2026-11-24
- Difficulty: Medium
- Topic: Intervals, Two Pointers
- Pattern: Advance the interval that ends first

## Problem

Given two lists of sorted, pairwise-disjoint closed intervals, return every
intersection between an interval from the first list and an interval from the
second list.

## Approach

Use one pointer for each list:

1. The overlap begins at the larger start and ends at the smaller end.
2. Save that range when its start is no greater than its end.
3. Advance the interval with the smaller ending position because it cannot
   overlap any later interval from the other list.

Each interval is visited at most once, and endpoint-only intersections are
included because the ranges are closed.

## Complexity

- Time: `O(m + n)`
- Space: `O(k)` for the `k` returned intersections.
