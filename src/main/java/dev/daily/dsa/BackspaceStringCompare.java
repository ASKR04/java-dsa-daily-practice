package dev.daily.dsa;

public final class BackspaceStringCompare {
    private BackspaceStringCompare() {
    }

    public static boolean compare(String s, String t) {
        return build(s).equals(build(t));
    }

    private static String build(String input) {
        StringBuilder stack = new StringBuilder();

        for (char current : input.toCharArray()) {
            if (current == '#') {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(current);
            }
        }

        return stack.toString();
    }
}
