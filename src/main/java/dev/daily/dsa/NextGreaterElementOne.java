package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class NextGreaterElementOne {
    private NextGreaterElementOne() {
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterByValue = buildNextGreaterMap(nums2);
        int[] result = new int[nums1.length];

        for (int index = 0; index < nums1.length; index++) {
            result[index] = nextGreaterByValue.getOrDefault(nums1[index], -1);
        }

        return result;
    }

    private static Map<Integer, Integer> buildNextGreaterMap(int[] nums) {
        Map<Integer, Integer> nextGreaterByValue = new HashMap<>();
        Deque<Integer> decreasingStack = new ArrayDeque<>();

        for (int value : nums) {
            while (!decreasingStack.isEmpty() && value > decreasingStack.peek()) {
                nextGreaterByValue.put(decreasingStack.pop(), value);
            }

            decreasingStack.push(value);
        }

        return nextGreaterByValue;
    }
}
