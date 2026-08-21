# Evaluate Reverse Polish Notation

- Date: 2026-08-21
- Difficulty: Medium
- Topic: Stack
- Pattern: Operand stack

## Problem

Given an array of tokens representing an arithmetic expression in Reverse Polish Notation, evaluate the expression and return its integer result.

Valid operators are `+`, `-`, `*`, and `/`. Every operator applies to the two most recent operands. Integer division truncates toward zero.

## Approach

Use a stack of integers:

1. Scan each token from left to right.
2. If the token is a number, push it onto the stack.
3. If the token is an operator, pop the right operand first, then the left operand.
4. Apply the operator and push the result back onto the stack.
5. After all tokens are processed, the final stack value is the answer.

The pop order matters for subtraction and division.

## Complexity

- Time: `O(n)`, where `n` is the number of tokens.
- Space: `O(n)` for the operand stack.
