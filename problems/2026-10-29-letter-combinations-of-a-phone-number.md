# Letter Combinations of a Phone Number

- Date: 2026-10-29
- Difficulty: Medium
- Topic: Backtracking
- Pattern: Cartesian product of choices

## Problem

Given a string containing digits from `2` through `9`, return every letter combination that the digits could represent using the traditional telephone keypad mapping. Return an empty list when the input is empty.

## Approach

Build one output string from left to right:

1. Map the current digit to its possible letters.
2. Append each possible letter in turn.
3. Recurse to choose a letter for the next digit.
4. Remove the appended letter before exploring the next branch.
5. Record the string when every digit has contributed one letter.

Each path through the recursion tree represents one element of the Cartesian product of the digit mappings.

## Complexity

- Time: `O(4^n * n)` in the worst case, including the cost of creating each output string.
- Space: `O(n)` auxiliary recursion and builder space, excluding the output.
