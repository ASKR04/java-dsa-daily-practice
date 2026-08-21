package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public final class EvaluateReversePolishNotation {
    private EvaluateReversePolishNotation() {
    }

    public static int evaluate(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int right = operands.pop();
                int left = operands.pop();
                operands.push(apply(left, right, token));
            } else {
                operands.push(Integer.parseInt(token));
            }
        }

        return operands.pop();
    }

    private static boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }

    private static int apply(int left, int right, String operator) {
        return switch (operator) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> throw new IllegalArgumentException("Unsupported operator: " + operator);
        };
    }
}
