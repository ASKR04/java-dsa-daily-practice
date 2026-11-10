package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LongestCommonSubsequenceTest {
    @Test
    void findsSubsequenceAcrossSkippedCharacters() {
        assertEquals(3, LongestCommonSubsequence.length("abcde", "ace"));
    }

    @Test
    void handlesIdenticalAndDisjointStrings() {
        assertEquals(3, LongestCommonSubsequence.length("abc", "abc"));
        assertEquals(0, LongestCommonSubsequence.length("abc", "def"));
    }

    @Test
    void doesNotReuseRepeatedCharacters() {
        assertEquals(2, LongestCommonSubsequence.length("aaaa", "aa"));
    }

    @Test
    void handlesEmptyStringsAndEitherArgumentOrder() {
        assertEquals(0, LongestCommonSubsequence.length("", "abc"));
        assertEquals(3, LongestCommonSubsequence.length("ace", "abcde"));
    }

    @Test
    void rejectsNullInputs() {
        assertThrows(
                NullPointerException.class,
                () -> LongestCommonSubsequence.length(null, "abc"));
        assertThrows(
                NullPointerException.class,
                () -> LongestCommonSubsequence.length("abc", null));
    }
}
