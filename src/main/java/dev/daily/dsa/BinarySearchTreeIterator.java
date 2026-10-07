package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public final class BinarySearchTreeIterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushLeftBranch(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("iterator is exhausted");
        }

        TreeNode node = stack.pop();
        pushLeftBranch(node.right);
        return node.value;
    }

    private void pushLeftBranch(TreeNode node) {
        TreeNode current = node;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }

    public static final class TreeNode {
        public final int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
