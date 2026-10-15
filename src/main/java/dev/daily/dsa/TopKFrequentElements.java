package dev.daily.dsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public final class TopKFrequentElements {
    private TopKFrequentElements() {
    }

    public static int[] topKFrequent(int[] values, int k) {
        Objects.requireNonNull(values, "values must not be null");
        if (k < 1) {
            throw new IllegalArgumentException("k must be positive");
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int value : values) {
            frequencies.merge(value, 1, Integer::sum);
        }
        if (k > frequencies.size()) {
            throw new IllegalArgumentException("k exceeds the number of distinct values");
        }

        Comparator<Map.Entry<Integer, Integer>> leastUsefulFirst = (first, second) -> {
            int byFrequency = Integer.compare(first.getValue(), second.getValue());
            if (byFrequency != 0) {
                return byFrequency;
            }
            return Integer.compare(second.getKey(), first.getKey());
        };

        PriorityQueue<Map.Entry<Integer, Integer>> topEntries =
                new PriorityQueue<>(leastUsefulFirst);
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            topEntries.offer(entry);
            if (topEntries.size() > k) {
                topEntries.remove();
            }
        }

        int[] result = new int[k];
        for (int index = k - 1; index >= 0; index--) {
            result[index] = topEntries.remove().getKey();
        }
        return result;
    }
}
