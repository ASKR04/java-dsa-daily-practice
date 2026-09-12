# Palindrome Linked List

- Date: 2026-09-11
- Difficulty: Easy
- Topic: Linked List
- Pattern: Slow and fast pointers, in-place reversal

## Problem

Given the head of a singly linked list, determine whether the list is a palindrome.

A palindrome reads the same forward and backward.

## Approach

Use slow and fast pointers to find the middle, then reverse the second half.

1. Move `slow` one step and `fast` two steps until `fast` reaches the end.
2. Reverse the list starting at `slow`.
3. Compare the first half and reversed second half node by node.
4. If all compared values match, the list is a palindrome.

This checks the list in linear time without using an array or stack.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
