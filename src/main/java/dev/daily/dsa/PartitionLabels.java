package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Splits a string so each character appears in at most one partition. */
public final class PartitionLabels {
    private PartitionLabels() {
    }

    public static List<Integer> partitionSizes(String text) {
        Objects.requireNonNull(text, "text must not be null");

        int[] lastPosition = new int[Character.MAX_VALUE + 1];
        for (int index = 0; index < text.length(); index++) {
            lastPosition[text.charAt(index)] = index;
        }

        List<Integer> sizes = new ArrayList<>();
        int partitionStart = 0;
        int partitionEnd = 0;

        for (int index = 0; index < text.length(); index++) {
            partitionEnd = Math.max(
                    partitionEnd, lastPosition[text.charAt(index)]);
            if (index == partitionEnd) {
                sizes.add(partitionEnd - partitionStart + 1);
                partitionStart = index + 1;
            }
        }

        return List.copyOf(sizes);
    }
}
