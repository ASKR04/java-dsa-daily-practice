# Course Schedule II

- Date: 2026-10-24
- Difficulty: Medium
- Topic: Graph
- Pattern: Topological sort, ordering

## Problem

There are `courseCount` courses labeled from `0` to `courseCount - 1`. Each pair `[course, requiredCourse]` means the required course must be completed first. Return one valid order for completing every course, or an empty array when no valid order exists.

## Approach

Use Kahn's topological-sort algorithm while recording each completed course:

1. Build directed edges from every required course to its dependent courses.
2. Count the incoming prerequisite edges for each course.
3. Enqueue all courses whose incoming count is zero.
4. Remove ready courses one at a time, append them to the result, and reduce their dependents' incoming counts.
5. Enqueue a dependent as soon as all of its prerequisites have been completed.

The result is valid only when it contains every course. A shorter result means a directed cycle prevented some courses from becoming ready.

## Complexity

- Time: `O(V + E)`, where `V` is the number of courses and `E` is the number of prerequisite pairs.
- Space: `O(V + E)` for graph storage, incoming counts, the queue, and the output order.
