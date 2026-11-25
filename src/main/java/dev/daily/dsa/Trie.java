package dev.daily.dsa;

import java.util.Objects;

/** A prefix tree for strings of lowercase English letters. */
public final class Trie {
    private final Node root = new Node();

    public void insert(String word) {
        validate(word);
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            int letter = word.charAt(index) - 'a';
            if (node.children[letter] == null) {
                node.children[letter] = new Node();
            }
            node = node.children[letter];
        }
        node.terminal = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.terminal;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String text) {
        validate(text);
        Node node = root;
        for (int index = 0; index < text.length(); index++) {
            node = node.children[text.charAt(index) - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private static void validate(String text) {
        Objects.requireNonNull(text, "text must not be null");
        for (int index = 0; index < text.length(); index++) {
            char letter = text.charAt(index);
            if (letter < 'a' || letter > 'z') {
                throw new IllegalArgumentException("text must contain only letters a through z");
            }
        }
    }

    private static final class Node {
        private final Node[] children = new Node[26];
        private boolean terminal;
    }
}
