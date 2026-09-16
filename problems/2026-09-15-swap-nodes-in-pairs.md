# Swap Nodes in Pairs

- Date: 2026-09-15
- Difficulty: Medium
- Topic: Linked List
- Pattern: Dummy node, pairwise pointer relinking

## Problem

Given the head of a singly linked list, swap every two adjacent nodes and return the updated head.

The node values should not be changed. Only links between nodes should be updated.

## Approach

Use a dummy node before the list to make head swaps easy.

1. Keep a `previous` pointer just before the pair being swapped.
2. Let `first` and `second` be the two nodes in the current pair.
3. Point `first.next` to the node after the pair.
4. Point `second.next` to `first`.
5. Point `previous.next` to `second`.
6. Move `previous` to `first` and continue.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
