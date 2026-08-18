# Backspace String Compare

- Date: 2026-08-17
- Difficulty: Easy
- Topic: Stack
- Pattern: Simulated text editing

## Problem

Given two strings `s` and `t`, return `true` when both strings are equal after processing every `#` as a backspace. A backspace deletes the previous character when one exists.

## Approach

Use `StringBuilder` as a stack for each input string.

1. Scan the string from left to right.
2. Push normal characters onto the builder.
3. On `#`, remove the last character when the builder is not empty.
4. Compare the two processed strings.

This keeps the implementation direct while practicing the stack pattern. A reverse two-pointer solution can reduce space, but the explicit stack version is the right fit for this roadmap step.

## Complexity

- Time: `O(n + m)`, where `n` and `m` are the lengths of the two strings.
- Space: `O(n + m)` for the processed strings.
