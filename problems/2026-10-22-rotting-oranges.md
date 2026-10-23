# Rotting Oranges

- Date: 2026-10-22
- Difficulty: Medium
- Topic: Graph
- Pattern: Multi-source breadth-first search

## Problem

Given a rectangular grid where `0` is empty, `1` is a fresh orange, and `2` is a rotten orange, return the minimum number of minutes until no fresh orange remains. Each minute, a rotten orange contaminates its vertically and horizontally adjacent fresh oranges. Return `-1` if this is impossible.

## Approach

Run breadth-first search from every initially rotten orange at the same time:

1. Add all rotten oranges to one queue and count the fresh oranges.
2. Process the queue one level at a time, where one level represents one minute.
3. Mark each newly reached fresh orange as rotten, decrement the fresh count, and enqueue it for the next minute.
4. Stop when no fresh orange remains or the queue is exhausted.

Using every initial source in one BFS ensures each orange is reached at its earliest possible minute. A separate state matrix preserves the input grid.

## Complexity

- Time: `O(rows * columns)` because each cell is processed at most once.
- Space: `O(rows * columns)` for the queue and rotten-state matrix.
