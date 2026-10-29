package dev.daily.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class CombinationSum {
    private CombinationSum() {
    }

    public static List<List<Integer>> find(int[] candidates, int target) {
        Objects.requireNonNull(candidates, "candidates must not be null");
        if (target < 0) {
            throw new IllegalArgumentException("target must not be negative");
        }
        validateCandidates(candidates);

        int[] sortedCandidates = candidates.clone();
        Arrays.sort(sortedCandidates);

        List<List<Integer>> result = new ArrayList<>();
        buildCombinations(
                sortedCandidates,
                target,
                0,
                new ArrayList<>(),
                result);
        return result;
    }

    private static void buildCombinations(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int index = start; index < candidates.length; index++) {
            int candidate = candidates[index];
            if (candidate > remaining) {
                break;
            }

            current.add(candidate);
            buildCombinations(
                    candidates,
                    remaining - candidate,
                    index,
                    current,
                    result);
            current.remove(current.size() - 1);
        }
    }

    private static void validateCandidates(int[] candidates) {
        Set<Integer> seen = new HashSet<>();
        for (int candidate : candidates) {
            if (candidate <= 0) {
                throw new IllegalArgumentException(
                        "candidates must contain only positive values");
            }
            if (!seen.add(candidate)) {
                throw new IllegalArgumentException(
                        "candidates must contain distinct values");
            }
        }
    }
}
