package dev.daily.dsa;

import java.util.HashMap;
import java.util.Map;

public final class LongestSubstringWithoutRepeatingCharacters {
    private LongestSubstringWithoutRepeatingCharacters() {
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) {
                left = lastSeen.get(current) + 1;
            }

            lastSeen.put(current, right);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}

