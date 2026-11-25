# Meeting Rooms II

- Date: 2026-11-24
- Difficulty: Medium
- Topic: Intervals, Sweep Line
- Pattern: Peak concurrent intervals

## Problem

Given an unsorted array of meetings with positive durations, return the
minimum number of rooms needed. Each meeting occupies its room over
`[start, end)`, so a room can be reused at the exact time a meeting ends.
An empty schedule needs zero rooms.

## Approach

Sort start times and end times separately. Before processing each start,
advance the end pointer past all meetings that have already ended, including
those ending at this start time. The number of rooms currently in use is the
number of starts processed minus the number of ends processed.

The peak occupancy is a lower bound because concurrent meetings cannot share
rooms. It is also sufficient: at each start, reuse any room freed by an
earlier end, and add a room only when none is available. The input is unchanged.

## Complexity

- Time: `O(n log n)` for sorting.
- Auxiliary space: `O(n)` for the two endpoint arrays.
