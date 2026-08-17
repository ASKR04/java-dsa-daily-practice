# Valid Parentheses

## Roadmap

- Level: Easy
- Topic: Stack
- Pattern: Matching pairs

## Problem

Given a string `s` containing only the characters `(`, `)`, `{`, `}`, `[` and `]`, return `true` if the input string is valid.

A string is valid when every opening bracket is closed by the same type of bracket, brackets close in the correct order, and every closing bracket has a matching opening bracket.

## Approach

Use a stack to store opening brackets. When a closing bracket appears, the top of the stack must be the matching opening bracket. If it is not, the string is invalid. At the end, the stack must be empty.

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Edge Cases

- Empty string
- Closing bracket appears first
- Brackets are correct types but wrong order
- Unclosed opening bracket remains

