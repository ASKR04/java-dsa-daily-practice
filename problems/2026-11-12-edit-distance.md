# Edit Distance

- Date: 2026-11-12
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Two-sequence prefix comparison

## Problem

Given two strings, return the minimum number of single-character insertions,
deletions, and replacements needed to transform the first string into the
second string.

## Approach

Let each state represent the edit distance between one prefix of the first
string and one prefix of the second:

1. If the final characters match, use the distance for both shorter prefixes.
2. Otherwise, add one to the best state produced by an insertion, deletion, or
   replacement.
3. Initialize an empty-prefix state with the number of characters that must be
   inserted or deleted.

Only the previous row and current row are required. The shorter string is used
for the columns so the two rolling arrays use as little space as possible.

## Complexity

- Time: `O(m * n)`
- Space: `O(min(m, n))`
