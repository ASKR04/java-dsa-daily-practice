# Design Add and Search Words Data Structure

- Date: 2026-11-27
- Difficulty: Medium
- Topic: Trie
- Pattern: Wildcard search with a frontier

## Problem

Build a dictionary that stores lowercase English words and searches for whole
words. Each dot in a search pattern matches exactly one letter. For example,
after adding `bad` and `cat`, `.at` matches but `..` does not. The empty
pattern matches only if the empty word has been inserted.

## Approach

Extend a trie with a search frontier. Start at the root. For a literal letter,
follow only that letter's edge from each candidate node. For a wildcard, follow
every existing child edge. After consuming the pattern, accept only if a
candidate marks the end of a stored word. An empty frontier means no later
character can make the pattern match.

## Complexity

- Insertion: `O(L)` time and up to `O(L)` new nodes for a word of length `L`.
- Search: `O(L + V)` time for a pattern of length `L` and `V` trie nodes
  visited, since the alphabet size is fixed. Wildcards can visit many branches.
- Search auxiliary space: `O(W)`, where `W` is the largest frontier size.
