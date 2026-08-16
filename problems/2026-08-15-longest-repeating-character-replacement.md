# Longest Repeating Character Replacement

## Roadmap

- Level: Medium
- Topic: Sliding Window
- Pattern: Variable-size window with frequency counts

## Problem

Given a string `s` of uppercase English letters and an integer `k`, return the length of the longest substring that can be converted into a string with all identical characters by replacing at most `k` characters.

## Approach

Use a sliding window with character frequencies. For a window of length `windowLength`, the minimum replacements needed to make all characters equal is:

```text
windowLength - countOfMostFrequentCharacter
```

Expand the right pointer, update the most frequent character count, and shrink from the left while the window needs more than `k` replacements. Track the largest valid window length.

## Complexity

- Time: `O(n)`
- Space: `O(1)` because the alphabet size is fixed

## Edge Cases

- `k` is `0`
- All characters are already identical
- Best window appears after shrinking
- Replacement budget covers the full string

