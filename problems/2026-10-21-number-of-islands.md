# Number of Islands

- Date: 2026-10-21
- Difficulty: Medium
- Topic: Graph
- Pattern: Grid traversal, connected components

## Problem

Given a rectangular grid containing land (`'1'`) and water (`'0'`), return the number of islands. Land cells connect vertically and horizontally, not diagonally.

## Approach

Treat every land cell as a graph node with up to four neighbors:

1. Scan every grid cell.
2. When unvisited land is found, increment the island count.
3. Run iterative depth-first search to mark every vertically or horizontally connected land cell.
4. Continue scanning for the next unvisited island.

A separate visited matrix preserves the input grid.

## Complexity

- Time: `O(rows * columns)`.
- Space: `O(rows * columns)` for visited state and the traversal stack.
