# Valid Palindrome

## Roadmap

- Level: Easy
- Topic: Two Pointers
- Pattern: Inward scan

## Problem

Given a string `s`, return `true` if it is a palindrome after converting uppercase letters to lowercase and removing all non-alphanumeric characters.

Return `false` otherwise.

## Approach

Use two pointers, one starting at the beginning and one at the end. Move each pointer inward until it points to an alphanumeric character. Compare the normalized characters. If any pair differs, the string is not a palindrome.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Edge Cases

- Empty string after filtering
- Mixed casing
- Punctuation and spaces
- Numeric characters

