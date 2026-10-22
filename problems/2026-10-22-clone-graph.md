# Clone Graph

- Date: 2026-10-22
- Difficulty: Medium
- Topic: Graph
- Pattern: Breadth-first search, graph copying

## Problem

Given a reference to a node in a connected graph, return a deep copy of every node and edge reachable from it. The graph may contain cycles, self-loops, duplicate edges, and nodes with equal values.

## Approach

Use breadth-first search and map each original node object to its clone:

1. Create the clone of the starting node and add the original to a queue.
2. Remove one original node at a time and examine its neighbors.
3. Create and enqueue a neighbor clone only when that exact node has not been seen.
4. Add each mapped neighbor clone to the current clone's adjacency list in the original order.

An identity-based map is used because node identity, rather than node value, determines whether two graph vertices are distinct. Recording a clone before enqueueing its original prevents cycles from causing repeated traversal.

## Complexity

- Time: `O(V + E)`, where `V` is the number of reachable vertices and `E` is the number of edges.
- Space: `O(V)` for the clone map and traversal queue, excluding the returned graph.
