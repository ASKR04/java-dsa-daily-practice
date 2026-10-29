package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Permutations {
    private Permutations() {
    }

    public static List<List<Integer>> generate(int[] numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");

        int[] working = numbers.clone();
        List<List<Integer>> result = new ArrayList<>();
        buildPermutations(working, 0, result);
        return result;
    }

    private static void buildPermutations(
            int[] numbers,
            int index,
            List<List<Integer>> result) {
        if (index == numbers.length) {
            List<Integer> permutation = new ArrayList<>(numbers.length);
            for (int number : numbers) {
                permutation.add(number);
            }
            result.add(permutation);
            return;
        }

        for (int candidate = index; candidate < numbers.length; candidate++) {
            swap(numbers, index, candidate);
            buildPermutations(numbers, index + 1, result);
            swap(numbers, index, candidate);
        }
    }

    private static void swap(int[] numbers, int left, int right) {
        int temporary = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temporary;
    }
}
