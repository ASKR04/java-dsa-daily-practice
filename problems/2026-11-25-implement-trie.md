# Implement Trie (Prefix Tree)

- Date: 2026-11-25
- Difficulty: Medium
- Topic: Trie
- Pattern: Shared prefixes with terminal markers

## Problem

Build a data structure that inserts words, looks up exact words, and checks
whether a path exists for a prefix. Inputs contain only lowercase English
letters. The empty prefix always matches; the empty word matches only after
insertion.

## Approach

Each edge represents one letter. Insertion walks from the root, creating any
missing nodes, and marks the final node as terminal. A prefix lookup succeeds
whenever the whole path exists, but an exact lookup also checks the terminal
marker. For example, after inserting `apple`, the path for `app` exists even
though `app` is not yet an inserted word.

## Complexity

Each operation takes `O(L)` time for input length `L`. A lookup uses `O(1)`
extra space. An insertion allocates at most `L` nodes; for a fixed alphabet,
total storage is proportional to the number of distinct prefixes.
