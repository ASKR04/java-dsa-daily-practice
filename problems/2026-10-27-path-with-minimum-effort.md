# Path With Minimum Effort

- Date: 2026-10-27
- Difficulty: Medium
- Topic: Graph
- Pattern: Minimax Dijkstra's algorithm

## Problem

Given a rectangular grid of heights, travel from the top-left cell to the bottom-right cell using vertical and horizontal moves. A route's effort is the largest absolute height difference between consecutive cells. Return the minimum possible route effort.

## Approach

Treat each cell as a graph node and adapt Dijkstra's algorithm:

1. Store the smallest known effort needed to reach each cell.
2. Process the cell with the lowest route effort from a min-priority queue.
3. For each neighbor, calculate the step's height difference.
4. The candidate route effort is the larger of the current effort and the new step.
5. Update the neighbor when this candidate improves its best known effort.

Because queue states are processed in increasing effort order, the first valid state removed for the destination is optimal.

## Complexity

- Time: `O(rows * columns * log(rows * columns))`.
- Space: `O(rows * columns)` for effort values and the priority queue.
