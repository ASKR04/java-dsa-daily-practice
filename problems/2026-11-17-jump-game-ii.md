# Jump Game II

- Date: 2026-11-17
- Difficulty: Medium
- Topic: Greedy
- Pattern: Breadth-first reachable frontiers

## Problem

Each value in a non-empty array represents the maximum distance that can be
jumped forward from that index. Return the minimum number of jumps needed to
reach the final index, or `-1` when the final index is unreachable.

## Approach

Treat every set of positions reachable with the same number of jumps as one
level:

1. Scan all positions inside the current jump's frontier.
2. Track the farthest position any of them can reach.
3. When the scan reaches the current frontier, take one jump and promote the
   farthest position to the next frontier.

Choosing the farthest next frontier leaves every shorter choice available and
therefore minimizes the number of levels, and jumps, required. If a frontier
cannot advance, the final index is unreachable. A `long` frontier prevents
overflow from very large jump values.

## Complexity

- Time: `O(n)`
- Space: `O(1)`
