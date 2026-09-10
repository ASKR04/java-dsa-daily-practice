# Remove Nth Node From End of List

- Date: 2026-09-10
- Difficulty: Medium
- Topic: Linked List
- Pattern: Two pointers with fixed gap

## Problem

Given the head of a singly linked list and an integer `n`, remove the `n`th node from the end of the list and return the updated head.

## Approach

Use two pointers separated by `n` nodes.

1. Add a dummy node before the head to simplify removing the first real node.
2. Move `fast` ahead by `n` steps.
3. Move `slow` and `fast` together until `fast` reaches the last node.
4. `slow.next` is the node to remove.
5. Bypass it by pointing `slow.next` to `slow.next.next`.

The dummy node keeps edge cases, such as removing the head, straightforward.

## Complexity

- Time: `O(n)`, where `n` is the number of nodes.
- Space: `O(1)`.
