package dev.daily.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public final class KthSmallestElementInBinarySearchTree {
    private KthSmallestElementInBinarySearchTree() {
    }

    public static int kthSmallest(TreeNode root, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k must be positive");
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        int remaining = k;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            remaining--;
            if (remaining == 0) {
                return current.value;
            }
            current = current.right;
        }

        throw new IllegalArgumentException("k exceeds the number of nodes");
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
