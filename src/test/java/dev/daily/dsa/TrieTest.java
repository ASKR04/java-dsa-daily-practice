package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TrieTest {
    @Test
    void distinguishesWordsFromPrefixes() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertTrue(trie.startsWith("app"));
        assertFalse(trie.search("app"));
        trie.insert("app");
        trie.insert("app");
        assertTrue(trie.search("app"));
        assertTrue(trie.search("apple"));
    }

    @Test
    void sharesPrefixesWithoutMixingBranches() {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cat");
        assertTrue(trie.search("car"));
        assertTrue(trie.search("cat"));
        assertFalse(trie.startsWith("cab"));
        assertFalse(trie.search("cart"));
    }

    @Test
    void handlesEmptyStringsAtTheRoot() {
        Trie trie = new Trie();
        assertTrue(trie.startsWith(""));
        assertFalse(trie.search(""));
        trie.insert("");
        assertTrue(trie.search(""));
        assertFalse(trie.startsWith("a"));
    }

    @Test
    void rejectsInvalidTextWithoutLeavingPartialEntries() {
        Trie trie = new Trie();
        assertThrows(IllegalArgumentException.class, () -> trie.insert("abc!"));
        assertFalse(trie.startsWith("a"));
        assertThrows(IllegalArgumentException.class, () -> trie.startsWith("z!"));
        assertThrows(NullPointerException.class, () -> trie.search(null));
    }
}
