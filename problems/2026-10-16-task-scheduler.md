# Task Scheduler

- Date: 2026-10-16
- Difficulty: Medium
- Topic: Heap / Priority Queue
- Pattern: Greedy max heap, cooldown cycles

## Problem

Given uppercase task identifiers and a non-negative cooldown, return the minimum number of intervals needed to execute every task. Identical tasks must be separated by at least the cooldown number of intervals, and idle intervals are allowed.

## Approach

Process tasks in cycles of `cooldown + 1` slots:

1. Count each task type and store positive counts in a max heap.
2. During one cycle, execute up to one instance of each currently most frequent task.
3. Hold unfinished tasks outside the heap until the cycle ends so they cannot repeat too soon.
4. Reinsert their remaining counts.
5. Add unused slots as idle time only when tasks still remain.

Choosing the most frequent available tasks first minimizes future forced idle intervals.

## Complexity

- Time: `O(t log a)`, where `t` is the number of tasks and `a` is the number of task types.
- Space: `O(a)`, which is constant for 26 uppercase letters.
