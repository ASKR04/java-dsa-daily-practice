# Contains Duplicate

## Roadmap

- Level: Easy
- Topic: Arrays
- Pattern: Hash set lookup

## Problem

Given an integer array `nums`, return `true` if any value appears at least twice. Return `false` if every value is distinct.

## Approach

Scan the array once while storing values in a hash set. If a value is already present before inserting it, the array contains a duplicate.

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Edge Cases

- Empty array
- Single element array
- Duplicate negative values
- Duplicate appears at the end of the array

