# Decode Ways

- Date: 2026-11-09
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: One-dimensional prefix transition

## Problem

Digits `1` through `26` map to letters `A` through `Z`. Given a string of
decimal digits, return the number of different ways to decode the complete
string. A zero cannot be decoded by itself, and a two-digit decoding must be
between `10` and `26` inclusive.

## Approach

For each prefix, a decoding can end with either its final single digit or its
final pair of digits. Add the previous prefix count when the single digit is
nonzero. Add the count from two positions back when the pair is between `10`
and `26`. Only those two earlier counts are needed, so the dynamic programming
table can be compressed to constant space.

The implementation rejects non-digit input and uses exact addition so a result
that exceeds the range of `long` is reported instead of silently wrapping.

## Complexity

- Time: `O(n)`
- Space: `O(1)`
