# Partition Labels

- Date: 2026-11-19
- Difficulty: Medium
- Topic: Greedy
- Pattern: Merge character occurrence ranges

## Problem

Split a string into as many contiguous parts as possible so every character
appears in at most one part. Return the size of each part in order.

## Approach

First record the final position of every character. Then scan from left to
right while maintaining the current partition's required ending position:

1. Extend the ending position to the last occurrence of each character seen.
2. Close the partition when the scan reaches that ending position.
3. Begin the next partition immediately after the closed one.

Closing at the first valid ending produces the most partitions possible. Any
earlier cut would separate a character from one of its later occurrences.

## Complexity

- Time: `O(n)`
- Space: `O(k)`, where `k` is the Java character range.
