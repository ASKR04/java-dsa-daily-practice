package dev.daily.dsa;

public final class MinimumDaysToMakeBouquets {
    private MinimumDaysToMakeBouquets() {
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = bloomDay[0];
        int right = bloomDay[0];

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int answer = right;

        while (left <= right) {
            int day = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, day)) {
                answer = day;
                right = day - 1;
            } else {
                left = day + 1;
            }
        }

        return answer;
    }

    private static boolean canMakeBouquets(int[] bloomDay, int requiredBouquets, int flowersPerBouquet, int day) {
        int bouquets = 0;
        int adjacentBlooms = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                adjacentBlooms++;
                if (adjacentBlooms == flowersPerBouquet) {
                    bouquets++;
                    adjacentBlooms = 0;
                }
            } else {
                adjacentBlooms = 0;
            }

            if (bouquets >= requiredBouquets) {
                return true;
            }
        }

        return false;
    }
}
