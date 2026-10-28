package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Subsets {
    private Subsets() {
    }

    public static List<List<Integer>> generate(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");

        List<List<Integer>> result = new ArrayList<>();
        buildSubsets(numbers, 0, new ArrayList<>(), result);
        return result;
    }

    private static void buildSubsets(
            int[] numbers,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {
        if (index == numbers.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        buildSubsets(numbers, index + 1, current, result);

        current.add(numbers[index]);
        buildSubsets(numbers, index + 1, current, result);
        current.remove(current.size() - 1);
    }
}
