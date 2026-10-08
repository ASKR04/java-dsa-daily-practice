package dev.daily.dsa;

import java.util.Objects;

public final class ConstructBinarySearchTreeFromPreorderTraversal {
    private ConstructBinarySearchTreeFromPreorderTraversal() {
    }

    public static TreeNode build(int[] preorder) {
        Objects.requireNonNull(preorder, "preorder must not be null");

        int[] index = {0};
        TreeNode root = buildWithinBounds(preorder, index, Long.MIN_VALUE, Long.MAX_VALUE);
        if (index[0] != preorder.length) {
            throw new IllegalArgumentException("values do not form a valid BST preorder traversal");
        }
        return root;
    }

    private static TreeNode buildWithinBounds(
            int[] preorder,
            int[] index,
            long lower,
            long upper) {
        if (index[0] == preorder.length) {
            return null;
        }

        int value = preorder[index[0]];
        if (value <= lower || value >= upper) {
            return null;
        }

        index[0]++;
        TreeNode node = new TreeNode(value);
        node.left = buildWithinBounds(preorder, index, lower, value);
        node.right = buildWithinBounds(preorder, index, value, upper);
        return node;
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
