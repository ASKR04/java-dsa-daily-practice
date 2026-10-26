# Network Delay Time

- Date: 2026-10-26
- Difficulty: Medium
- Topic: Graph
- Pattern: Dijkstra's shortest path

## Problem

A directed edge `[source, destination, travelTime]` describes how long a signal takes to travel between two network nodes labeled from `1` to `n`. Given a starting node, return the minimum time until every node receives the signal, or `-1` if any node is unreachable.

## Approach

Run Dijkstra's algorithm from the starting node:

1. Build a directed adjacency list containing each destination and travel time.
2. Store the shortest known distance to every node, initially infinity except for the source.
3. Use a min-priority queue to process the node with the smallest known distance.
4. Relax each outgoing edge and enqueue a new state whenever a shorter route is found.
5. Ignore stale queue entries whose distance no longer matches the best known value.

When all shortest paths are known, the largest distance is the time when the final node receives the signal.

## Complexity

- Time: `O((V + E) log V)` with an adjacency list and priority queue.
- Space: `O(V + E)` for graph storage, distances, and the queue.
