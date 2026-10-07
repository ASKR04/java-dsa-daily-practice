# Binary Search Tree Iterator

- Date: 2026-10-07
- Difficulty: Medium
- Topic: Binary Search Tree
- Pattern: Lazy inorder traversal, stack

## Problem

Implement an iterator over a binary search tree with `next()` returning the next smallest value and `hasNext()` reporting whether another value exists.

The iterator should use `O(h)` memory, where `h` is the tree height, and provide amortized `O(1)` calls to `next()`.

## Approach

Keep a stack containing the path to the next smallest node:

1. During construction, push the root and every left descendant.
2. For `next()`, pop the top node; it is the next inorder value.
3. Push the popped node's right child and all of that child's left descendants.
4. `hasNext()` checks whether the stack is non-empty.

Each node is pushed and popped exactly once across the iterator's lifetime.

## Complexity

- Constructor: `O(h)` time.
- `next()`: `O(1)` amortized time.
- `hasNext()`: `O(1)` time.
- Space: `O(h)`.
