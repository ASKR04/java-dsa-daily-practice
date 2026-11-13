# Word Break

- Date: 2026-11-13
- Difficulty: Medium
- Topic: Dynamic Programming
- Pattern: Reachable string prefixes

## Problem

Given a string and a dictionary of words, determine whether the entire string
can be split into a sequence of one or more dictionary words. A dictionary word
may be used more than once.

## Approach

Track whether every prefix ending at each character position is reachable:

1. The empty prefix is reachable before any words are chosen.
2. For each ending position, inspect possible starts whose preceding prefix is
   reachable.
3. Mark the ending position reachable when the intervening substring is in the
   dictionary.

The maximum dictionary word length limits how far backward each search needs
to go. Empty dictionary entries are ignored because they cannot advance to a
new character position.

## Complexity

- Time: `O(n * L^2)` with substring construction, where `L` is the maximum
  dictionary word length.
- Space: `O(n + d)`, where `d` is the dictionary size.
