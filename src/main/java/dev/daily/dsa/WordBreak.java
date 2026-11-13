package dev.daily.dsa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** Determines whether a string can be segmented into dictionary words. */
public final class WordBreak {
    private WordBreak() {
    }

    public static boolean canSegment(String text, Set<String> dictionary) {
        Objects.requireNonNull(text, "text must not be null");
        Objects.requireNonNull(dictionary, "dictionary must not be null");

        Set<String> words = new HashSet<>();
        int maximumLength = 0;
        for (String word : dictionary) {
            Objects.requireNonNull(word, "dictionary must not contain null");
            if (!word.isEmpty()) {
                words.add(word);
                maximumLength = Math.max(maximumLength, word.length());
            }
        }

        boolean[] reachable = new boolean[text.length() + 1];
        reachable[0] = true;

        for (int end = 1; end <= text.length(); end++) {
            int earliestStart = Math.max(0, end - maximumLength);
            for (int start = earliestStart; start < end; start++) {
                if (reachable[start]
                        && words.contains(text.substring(start, end))) {
                    reachable[end] = true;
                    break;
                }
            }
        }

        return reachable[text.length()];
    }
}
