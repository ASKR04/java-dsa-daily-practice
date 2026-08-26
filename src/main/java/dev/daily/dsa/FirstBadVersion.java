package dev.daily.dsa;

import java.util.function.IntPredicate;

public final class FirstBadVersion {
    private FirstBadVersion() {
    }

    public static int findFirstBadVersion(int n, IntPredicate isBadVersion) {
        int left = 1;
        int right = n;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (isBadVersion.test(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
