# Redundant Connection

- Date: 2026-10-25
- Difficulty: Medium
- Topic: Graph
- Pattern: Disjoint-set union, cycle detection

## Problem

An undirected graph started as a tree with vertices labeled from `1` to `n`, then one extra edge was added. Given its edges, return the edge that can be removed to restore a tree.

## Approach

Process the edges with a disjoint-set union structure:

1. Initially place every vertex in its own component.
2. For each edge, find the representative of both endpoints.
3. If the representatives match, the endpoints are already connected and this edge closes a cycle.
4. Otherwise, merge their components and continue.

Path compression shortens future representative searches, while union by size keeps the component trees shallow.

## Complexity

- Time: `O(E * alpha(V))`, effectively linear, where `alpha` is the inverse Ackermann function.
- Space: `O(V)` for parent and component-size arrays.
