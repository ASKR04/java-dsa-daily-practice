# Longest Common Subsequence

- Date: 2026-11-10
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Two-sequence prefix comparison

## Problem

Given two strings, return the length of their longest common subsequence. A
subsequence preserves character order but may omit characters, and its
characters do not need to be adjacent in the original strings.

## Approach

Compare every prefix of one string with every prefix of the other:

1. When the final characters match, extend the best result for both shorter
   prefixes by one.
2. When they differ, keep the better result obtained by removing the final
   character from either prefix.

Each row depends only on the preceding row and the current row's previous
value. Two arrays therefore replace the full dynamic-programming matrix. The
shorter string is used for the columns to minimize auxiliary space.

## Complexity

- Time: `O(m * n)`
- Space: `O(min(m, n))`
