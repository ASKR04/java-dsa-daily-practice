# Course Schedule

- Date: 2026-10-23
- Difficulty: Medium
- Topic: Graph
- Pattern: Topological sort, cycle detection

## Problem

There are `courseCount` courses labeled from `0` to `courseCount - 1`. Each prerequisite pair `[course, requiredCourse]` means the required course must be completed first. Return whether every course can be completed.

## Approach

Model the prerequisites as a directed graph and run Kahn's topological-sort algorithm:

1. Build an adjacency list from each required course to the courses that depend on it.
2. Count the incoming prerequisite edges for every course.
3. Add all courses with no remaining prerequisites to a queue.
4. Repeatedly complete a ready course and reduce the incoming count of its dependents.
5. A dependent becomes ready when its incoming count reaches zero.

If all courses leave the queue, the graph is acyclic and the schedule is possible. If some courses remain, they belong to or depend on a directed cycle.

## Complexity

- Time: `O(V + E)`, where `V` is the number of courses and `E` is the number of prerequisite pairs.
- Space: `O(V + E)` for the adjacency list, incoming counts, and queue.
