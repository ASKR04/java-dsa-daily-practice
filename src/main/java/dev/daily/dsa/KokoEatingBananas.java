package dev.daily.dsa;

public final class KokoEatingBananas {
    private KokoEatingBananas() {
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);
        int answer = right;

        while (left <= right) {
            int speed = left + (right - left) / 2;

            if (canFinish(piles, h, speed)) {
                answer = speed;
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }

        return answer;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1L) / speed;
            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    private static int max(int[] values) {
        int maximum = values[0];

        for (int value : values) {
            maximum = Math.max(maximum, value);
        }

        return maximum;
    }
}
