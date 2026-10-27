# Minimum Cost to Connect All Points

- Date: 2026-10-27
- Difficulty: Medium
- Topic: Graph
- Pattern: Minimum spanning tree, Prim's algorithm

## Problem

Given points on a two-dimensional plane, connect every point so that exactly one path exists between each pair. The cost of connecting two points is their Manhattan distance. Return the minimum total connection cost.

## Approach

Treat the points as a complete weighted graph and build a minimum spanning tree with Prim's algorithm:

1. Start with one point in the tree at zero cost.
2. Track the cheapest known edge connecting each remaining point to the tree.
3. Repeatedly add the point with the smallest connection cost.
4. Update every remaining point using its Manhattan distance from the newly added point.

The complete graph is evaluated lazily, so its `O(n^2)` edges do not need to be stored.

## Complexity

- Time: `O(n^2)` for selecting points and updating connection costs.
- Space: `O(n)` for tree membership and minimum connection costs.
