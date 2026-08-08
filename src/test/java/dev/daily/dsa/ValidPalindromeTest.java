package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeTest {
    @Test
    void returnsTrueWhenPhraseIsPalindromeAfterNormalization() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void returnsFalseWhenNormalizedCharactersDiffer() {
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
    }

    @Test
    void returnsTrueWhenOnlyNonAlphanumericCharactersExist() {
        assertTrue(ValidPalindrome.isPalindrome("., "));
    }

    @Test
    void handlesNumbersAsComparableCharacters() {
        assertFalse(ValidPalindrome.isPalindrome("0P"));
    }
}

