package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public final class DailyTemperatures {
    private DailyTemperatures() {
    }

    public static int[] daysUntilWarmer(int[] temperatures) {
        int[] waits = new int[temperatures.length];
        Deque<Integer> decreasingStack = new ArrayDeque<>();

        for (int index = 0; index < temperatures.length; index++) {
            while (!decreasingStack.isEmpty()
                    && temperatures[index] > temperatures[decreasingStack.peek()]) {
                int previousIndex = decreasingStack.pop();
                waits[previousIndex] = index - previousIndex;
            }

            decreasingStack.push(index);
        }

        return waits;
    }
}
