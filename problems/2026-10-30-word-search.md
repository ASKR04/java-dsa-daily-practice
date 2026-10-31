# Word Search

- Date: 2026-10-30
- Difficulty: Medium
- Topic: Backtracking
- Pattern: Grid path search with visited state

## Problem

Given a rectangular character grid and a word, determine whether the word can be formed by horizontally or vertically adjacent cells. A cell may be used at most once in a path.

## Approach

Try every grid cell as the start of the word and run a depth-first backtracking search:

1. Reject positions that are outside the grid, already used, or do not match the current character.
2. Mark a matching cell as visited.
3. Search its four neighbors for the next character.
4. Unmark the cell before returning so another path may use it.
5. Succeed when every character has been matched.

A separate visited matrix preserves the caller's board while still preventing a path from reusing a cell.

## Complexity

- Time: `O(rows * columns * 4^length)` in the worst case.
- Space: `O(rows * columns + length)` for visited state and recursion.
