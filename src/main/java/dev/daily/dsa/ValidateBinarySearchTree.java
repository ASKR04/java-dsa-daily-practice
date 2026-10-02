package dev.daily.dsa;

public final class ValidateBinarySearchTree {
    private ValidateBinarySearchTree() {
    }

    public static boolean isValid(TreeNode root) {
        return isWithinBounds(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isWithinBounds(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.value <= lower || node.value >= upper) {
            return false;
        }

        return isWithinBounds(node.left, lower, node.value)
                && isWithinBounds(node.right, node.value, upper);
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
