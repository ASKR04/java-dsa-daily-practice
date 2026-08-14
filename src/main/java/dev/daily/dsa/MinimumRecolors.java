package dev.daily.dsa;

public final class MinimumRecolors {
    private MinimumRecolors() {
    }

    public static int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        for (int index = 0; index < k; index++) {
            if (blocks.charAt(index) == 'W') {
                whiteCount++;
            }
        }

        int best = whiteCount;
        for (int right = k; right < blocks.length(); right++) {
            if (blocks.charAt(right) == 'W') {
                whiteCount++;
            }
            if (blocks.charAt(right - k) == 'W') {
                whiteCount--;
            }
            best = Math.min(best, whiteCount);
        }

        return best;
    }
}

