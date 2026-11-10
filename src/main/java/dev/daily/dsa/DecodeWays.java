package dev.daily.dsa;

import java.util.Objects;

/** Counts valid decodings where 1 through 26 map to A through Z. */
public final class DecodeWays {
    private DecodeWays() {
    }

    public static long count(String digits) {
        Objects.requireNonNull(digits, "digits must not be null");
        if (digits.isEmpty()) {
            return 0;
        }

        for (int index = 0; index < digits.length(); index++) {
            if (!Character.isDigit(digits.charAt(index))) {
                throw new IllegalArgumentException("digits must contain only decimal digits");
            }
        }

        long twoBack = 1;
        long oneBack = digits.charAt(0) == '0' ? 0 : 1;

        for (int index = 1; index < digits.length(); index++) {
            long current = 0;
            char digit = digits.charAt(index);

            if (digit != '0') {
                current = oneBack;
            }

            int pair = (digits.charAt(index - 1) - '0') * 10 + (digit - '0');
            if (pair >= 10 && pair <= 26) {
                current = Math.addExact(current, twoBack);
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
