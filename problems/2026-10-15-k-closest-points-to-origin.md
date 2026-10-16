# K Closest Points to Origin

- Date: 2026-10-15
- Difficulty: Medium
- Topic: Heap / Priority Queue
- Pattern: Bounded max heap

## Problem

Given points on a two-dimensional plane and an integer `k`, return the `k` points closest to the origin. Distance ties may be resolved in any order.

## Approach

Maintain a max heap containing the best `k` points seen so far:

1. Compare points by squared Euclidean distance, avoiding square roots.
2. Add each point to the heap.
3. When the heap grows beyond `k`, remove its farthest point.
4. Extract the retained points from farthest to closest into the result array from back to front.

Squared distances use `long` arithmetic to avoid integer overflow. Coordinate ordering makes distance ties deterministic.

## Complexity

- Time: `O(n log k)`.
- Space: `O(k)`, excluding the returned point copies.
