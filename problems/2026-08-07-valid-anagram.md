# Valid Anagram

## Roadmap

- Level: Easy
- Topic: Hash Map
- Pattern: Frequency counting

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`. Return `false` otherwise.

An anagram uses the same characters with the same frequencies, but may appear in a different order.

## Approach

If the strings have different lengths, they cannot be anagrams. Otherwise, count each character from `s`, then subtract counts while scanning `t`. If any count would go below zero, `t` uses a character too many times.

## Complexity

- Time: `O(n)`
- Space: `O(k)`, where `k` is the number of distinct characters

## Edge Cases

- Different string lengths
- Same characters with different counts
- Empty strings
- Identical strings

