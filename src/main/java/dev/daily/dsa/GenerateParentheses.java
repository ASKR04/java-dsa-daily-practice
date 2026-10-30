package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;

public final class GenerateParentheses {
    private GenerateParentheses() {
    }

    public static List<String> generate(int pairs) {
        if (pairs < 0) {
            throw new IllegalArgumentException("pairs must not be negative");
        }

        List<String> result = new ArrayList<>();
        buildCombinations(
                pairs,
                0,
                0,
                new StringBuilder(pairs * 2),
                result);
        return result;
    }

    private static void buildCombinations(
            int pairs,
            int open,
            int closed,
            StringBuilder current,
            List<String> result) {
        if (current.length() == pairs * 2) {
            result.add(current.toString());
            return;
        }

        if (open < pairs) {
            current.append('(');
            buildCombinations(pairs, open + 1, closed, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (closed < open) {
            current.append(')');
            buildCombinations(pairs, open, closed + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
