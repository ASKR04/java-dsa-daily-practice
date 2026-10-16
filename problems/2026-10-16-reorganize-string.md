# Reorganize String

- Date: 2026-10-16
- Difficulty: Medium
- Topic: Heap / Priority Queue
- Pattern: Greedy max heap, one-step holdback

## Problem

Given a string of lowercase letters, rearrange its characters so no two adjacent characters are equal. Return any valid arrangement, or an empty string when none exists.

## Approach

Use a max heap ordered by remaining character frequency:

1. Count each character and add present characters to the heap.
2. Remove the most frequent available character and append it.
3. Keep that character out of the heap for one iteration so it cannot repeat immediately.
4. Reinsert the previously used character when it still has remaining copies.
5. If construction stops before using every character, no valid arrangement exists.

The deterministic tie breaker prefers alphabetically smaller characters.

## Complexity

- Time: `O(n log a)`, where `a` is the alphabet size; with lowercase English letters this is `O(n)`.
- Space: `O(a)`, which is constant for the fixed alphabet.
