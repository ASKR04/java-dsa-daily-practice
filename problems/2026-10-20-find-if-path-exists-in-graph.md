# Find if Path Exists in Graph

- Date: 2026-10-20
- Difficulty: Easy
- Topic: Graph
- Pattern: Adjacency list, breadth-first search

## Problem

Given an undirected graph with nodes numbered from `0` to `n - 1`, determine whether a path exists between a source node and a destination node.

## Approach

Build an adjacency list and run breadth-first search:

1. Add both directions for every undirected edge.
2. Mark the source visited and add it to a queue.
3. Repeatedly remove a node and enqueue each unvisited neighbor.
4. Return `true` when the destination is reached.
5. Return `false` when the reachable component is exhausted.

Marking nodes when they enter the queue prevents duplicate work around cycles.

## Complexity

- Time: `O(V + E)`.
- Space: `O(V + E)` for the adjacency list, visited array, and queue.
