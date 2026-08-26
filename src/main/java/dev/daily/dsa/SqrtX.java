package dev.daily.dsa;

public final class SqrtX {
    private SqrtX() {
    }

    public static int sqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int answer = 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (middle <= x / middle) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return answer;
    }
}
