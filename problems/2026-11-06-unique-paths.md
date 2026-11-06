# Unique Paths

- Date: 2026-11-06
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Compressed two-dimensional grid transition

## Problem

A robot starts in the top-left cell of a positive-sized grid and may move only right or down. Return the number of distinct paths to the bottom-right cell.

## Approach

The number of paths to a cell is the sum of the paths to the cell above it and the cell to its left:

1. Initialize the first row and first column with one path each.
2. Reuse a one-dimensional array for the current row.
3. Before an update, an entry stores the paths from above.
4. Its left neighbor stores the paths from the current row.
5. Add those values to obtain the current cell's path count.

The smaller grid dimension is used for the array to reduce memory. Exact addition reports an overflow instead of returning a corrupted `long` result.

## Complexity

- Time: `O(rows * columns)`.
- Space: `O(min(rows, columns))`.
