package dev.daily.dsa;

public final class MaxConsecutiveOnes {
    private MaxConsecutiveOnes() {
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int best = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroes++;
            }

            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}

