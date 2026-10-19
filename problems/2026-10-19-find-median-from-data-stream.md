# Find Median from Data Stream

- Date: 2026-10-19
- Difficulty: Hard
- Topic: Heap / Priority Queue
- Pattern: Two heaps, streaming data

## Problem

Design a data structure that accepts integers from a stream and returns the median of all values seen so far at any time.

## Approach

Split the stream between two heaps:

1. A max heap stores the lower half of the values.
2. A min heap stores the upper half.
3. Insert according to the lower heap's maximum, then rebalance so the lower heap has either the same number of values or one extra.
4. For an odd count, the lower heap maximum is the median.
5. For an even count, average both heap roots using `long` addition to avoid integer overflow.

These invariants keep the two middle values immediately available.

## Complexity

- Addition: `O(log n)`.
- Median lookup: `O(1)`.
- Space: `O(n)`.
