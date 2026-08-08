package dev.daily.dsa;

import java.util.HashMap;
import java.util.Map;

public final class ValidAnagram {
    private ValidAnagram() {
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char current : s.toCharArray()) {
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
        }

        for (char current : t.toCharArray()) {
            int remaining = frequencies.getOrDefault(current, 0);
            if (remaining == 0) {
                return false;
            }

            if (remaining == 1) {
                frequencies.remove(current);
            } else {
                frequencies.put(current, remaining - 1);
            }
        }

        return frequencies.isEmpty();
    }
}

