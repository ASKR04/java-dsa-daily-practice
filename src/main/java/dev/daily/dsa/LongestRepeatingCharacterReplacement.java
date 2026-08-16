package dev.daily.dsa;

public final class LongestRepeatingCharacterReplacement {
    private LongestRepeatingCharacterReplacement() {
    }

    public static int characterReplacement(String s, int k) {
        int[] frequencies = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            int rightIndex = s.charAt(right) - 'A';
            frequencies[rightIndex]++;
            maxFrequency = Math.max(maxFrequency, frequencies[rightIndex]);

            while ((right - left + 1) - maxFrequency > k) {
                int leftIndex = s.charAt(left) - 'A';
                frequencies[leftIndex]--;
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}

