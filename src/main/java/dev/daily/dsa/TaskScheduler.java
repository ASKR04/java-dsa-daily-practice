package dev.daily.dsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public final class TaskScheduler {
    private static final int TASK_TYPES = 26;

    private TaskScheduler() {
    }

    public static int leastIntervals(char[] tasks, int cooldown) {
        Objects.requireNonNull(tasks, "tasks must not be null");
        if (cooldown < 0) {
            throw new IllegalArgumentException("cooldown must be non-negative");
        }

        int[] frequencies = new int[TASK_TYPES];
        for (char task : tasks) {
            if (task < 'A' || task > 'Z') {
                throw new IllegalArgumentException("tasks must be uppercase letters");
            }
            frequencies[task - 'A']++;
        }

        PriorityQueue<Integer> remainingCounts =
                new PriorityQueue<>(Comparator.reverseOrder());
        for (int frequency : frequencies) {
            if (frequency > 0) {
                remainingCounts.offer(frequency);
            }
        }

        int intervals = 0;
        while (!remainingCounts.isEmpty()) {
            int availableSlots = cooldown + 1;
            List<Integer> unfinishedTasks = new ArrayList<>();

            while (availableSlots > 0 && !remainingCounts.isEmpty()) {
                int remaining = remainingCounts.remove() - 1;
                intervals++;
                availableSlots--;

                if (remaining > 0) {
                    unfinishedTasks.add(remaining);
                }
            }

            remainingCounts.addAll(unfinishedTasks);
            if (!remainingCounts.isEmpty()) {
                intervals += availableSlots;
            }
        }

        return intervals;
    }
}
