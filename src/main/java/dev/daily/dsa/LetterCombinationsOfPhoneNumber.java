package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LetterCombinationsOfPhoneNumber {
    private static final String[] LETTERS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private LetterCombinationsOfPhoneNumber() {
    }

    public static List<String> generate(String digits) {
        Objects.requireNonNull(digits, "digits must not be null");
        validateDigits(digits);
        if (digits.isEmpty()) {
            return List.of();
        }

        List<String> result = new ArrayList<>();
        buildCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void buildCombinations(
            String digits,
            int index,
            StringBuilder current,
            List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String choices = LETTERS[digits.charAt(index) - '0'];
        for (int choice = 0; choice < choices.length(); choice++) {
            current.append(choices.charAt(choice));
            buildCombinations(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    private static void validateDigits(String digits) {
        for (int index = 0; index < digits.length(); index++) {
            char digit = digits.charAt(index);
            if (digit < '2' || digit > '9') {
                throw new IllegalArgumentException(
                        "digits must contain only values from 2 through 9");
            }
        }
    }
}
