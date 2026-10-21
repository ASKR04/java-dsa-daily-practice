# Number of Connected Components in an Undirected Graph

- Date: 2026-10-21
- Difficulty: Medium
- Topic: Graph
- Pattern: Adjacency list, repeated depth-first search

## Problem

Given an undirected graph with nodes numbered from `0` to `n - 1`, return the number of connected components.

## Approach

Build an adjacency list, then scan every node:

1. Skip nodes already visited by an earlier traversal.
2. For each unvisited node, increment the component count.
3. Run iterative depth-first search from that node and mark every reachable node.
4. Continue scanning for the next unvisited starting point.

Marking a node when it enters the stack prevents duplicate pushes around cycles.

## Complexity

- Time: `O(V + E)`.
- Space: `O(V + E)` for the adjacency list, visited array, and stack.
