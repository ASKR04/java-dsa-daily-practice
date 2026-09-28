package dev.daily.dsa;

public final class BalancedBinaryTree {
    private BalancedBinaryTree() {
    }

    public static boolean isBalanced(TreeNode root) {
        return heightOrUnbalanced(root) != -1;
    }

    private static int heightOrUnbalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightOrUnbalanced(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = heightOrUnbalanced(node.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
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
