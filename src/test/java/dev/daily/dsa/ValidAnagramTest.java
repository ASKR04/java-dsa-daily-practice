package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {
    @Test
    void returnsTrueWhenStringsContainSameCharacterCounts() {
        assertTrue(ValidAnagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    void returnsFalseWhenCharacterCountsDiffer() {
        assertFalse(ValidAnagram.isAnagram("rat", "car"));
    }

    @Test
    void returnsFalseWhenLengthsDiffer() {
        assertFalse(ValidAnagram.isAnagram("ab", "a"));
    }

    @Test
    void returnsTrueForEmptyStrings() {
        assertTrue(ValidAnagram.isAnagram("", ""));
    }
}

