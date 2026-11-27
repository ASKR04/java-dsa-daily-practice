package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WordDictionaryTest {
    @Test
    void exploresAlternateBranchesForWildcards() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("bed");
        dictionary.addWord("cat");

        assertTrue(dictionary.search("bad"));
        assertTrue(dictionary.search(".at"));
        assertTrue(dictionary.search("b.d"));
        assertTrue(dictionary.search("..."));
        assertFalse(dictionary.search("b.t"));
    }

    @Test
    void requiresACompleteWordOfTheSameLength() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("cart");

        assertFalse(dictionary.search("car"));
        assertFalse(dictionary.search("c.."));
        assertFalse(dictionary.search("cart."));
        assertFalse(dictionary.search(""));
        dictionary.addWord("");
        assertTrue(dictionary.search(""));
        assertFalse(dictionary.search("."));
    }

    @Test
    void validatesWordsAndPatterns() {
        WordDictionary dictionary = new WordDictionary();
        assertThrows(IllegalArgumentException.class, () -> dictionary.addWord("a.b"));
        assertThrows(IllegalArgumentException.class, () -> dictionary.search("z!"));
        assertThrows(NullPointerException.class, () -> dictionary.search(null));
    }
}
