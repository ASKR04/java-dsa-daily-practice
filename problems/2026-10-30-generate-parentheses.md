# Generate Parentheses

- Date: 2026-10-30
- Difficulty: Medium
- Topic: Backtracking
- Pattern: Constrained sequence construction

## Problem

Given a non-negative number of parenthesis pairs, return every string that uses all pairs and is correctly balanced.

## Approach

Build each string from left to right while tracking how many opening and closing parentheses have been used:

1. Add an opening parenthesis while fewer than the requested number have been used.
2. Add a closing parenthesis only when it can match an existing unmatched opening parenthesis.
3. Undo each choice after its recursive branch finishes.
4. Record a string when its length reaches twice the number of pairs.

These constraints prevent invalid prefixes from entering the search tree, so no generated string needs a separate validity check.

## Complexity

- Time: `O(Cn * n)`, where `Cn` is the `n`th Catalan number, including output construction.
- Space: `O(n)` auxiliary recursion and builder space, excluding the output.
