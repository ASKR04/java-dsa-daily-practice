package dev.daily.dsa;

import java.util.HashSet;
import java.util.Set;

public final class ContainsDuplicateWithinDistance {
    private ContainsDuplicateWithinDistance() {
    }

    public static boolean hasNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            if (window.contains(nums[index])) {
                return true;
            }

            window.add(nums[index]);
            if (window.size() > k) {
                window.remove(nums[index - k]);
            }
        }

        return false;
    }
}

