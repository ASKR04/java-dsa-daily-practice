package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ValidParentheses {
    private ValidParentheses() {
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char current : s.toCharArray()) {
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char open = stack.pop();
            if (!isMatchingPair(open, current)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}

