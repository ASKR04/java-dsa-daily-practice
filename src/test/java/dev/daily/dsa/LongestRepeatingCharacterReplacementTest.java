package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestRepeatingCharacterReplacementTest {
    @Test
    void findsLongestSubstringAfterLimitedReplacements() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("ABAB", 2));
    }

    @Test
    void handlesWindowThatRequiresShrinking() {
        assertEquals(4, LongestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
    }

    @Test
    void handlesZeroReplacementBudget() {
        assertEquals(2, LongestRepeatingCharacterReplacement.characterReplacement("AABBA", 0));
    }

    @Test
    void returnsFullLengthWhenAlreadyUniform() {
        assertEquals(5, LongestRepeatingCharacterReplacement.characterReplacement("AAAAA", 1));
    }
}

