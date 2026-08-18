# Implement Queue using Stacks

- Date: 2026-08-18
- Difficulty: Easy
- Topic: Stack, Queue
- Pattern: Amortized transfer

## Problem

Design a first-in-first-out queue using only stack operations.

Support these operations:

- `push(x)`: add `x` to the back of the queue.
- `pop()`: remove and return the front element.
- `peek()`: return the front element without removing it.
- `empty()`: return whether the queue has no elements.

## Approach

Use two stacks:

- `inStack` stores newly pushed values.
- `outStack` stores values in queue order for `pop` and `peek`.

When `outStack` is empty and the queue needs its front element, move every value from `inStack` to `outStack`. This reverses the insertion order once, so the oldest value becomes the top of `outStack`.

Each element moves from `inStack` to `outStack` at most one time, giving efficient amortized queue operations.

## Complexity

- Time: `O(1)` amortized for each operation.
- Space: `O(n)` for the two stacks.
