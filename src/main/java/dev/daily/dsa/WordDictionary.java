package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Stores words and searches exact-length patterns with single-letter wildcards. */
public final class WordDictionary {
    private final Node root = new Node();

    public void addWord(String word) {
        validate(word, false);
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            int child = word.charAt(index) - 'a';
            if (node.children[child] == null) {
                node.children[child] = new Node();
            }
            node = node.children[child];
        }
        node.terminal = true;
    }

    public boolean search(String pattern) {
        validate(pattern, true);
        List<Node> frontier = List.of(root);
        for (int index = 0; index < pattern.length(); index++) {
            char letter = pattern.charAt(index);
            List<Node> next = new ArrayList<>();
            for (Node node : frontier) {
                if (letter == '.') {
                    for (Node child : node.children) {
                        if (child != null) {
                            next.add(child);
                        }
                    }
                } else {
                    Node child = node.children[letter - 'a'];
                    if (child != null) {
                        next.add(child);
                    }
                }
            }
            if (next.isEmpty()) {
                return false;
            }
            frontier = next;
        }
        for (Node node : frontier) {
            if (node.terminal) {
                return true;
            }
        }
        return false;
    }

    private static void validate(String text, boolean allowWildcard) {
        Objects.requireNonNull(text, "text must not be null");
        for (int index = 0; index < text.length(); index++) {
            char letter = text.charAt(index);
            if ((letter < 'a' || letter > 'z') && !(allowWildcard && letter == '.')) {
                throw new IllegalArgumentException("invalid character in word or pattern");
            }
        }
    }

    private static final class Node {
        private final Node[] children = new Node[26];
        private boolean terminal;
    }
}
