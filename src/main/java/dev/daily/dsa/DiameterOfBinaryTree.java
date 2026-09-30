package dev.daily.dsa;

public final class DiameterOfBinaryTree {
    private DiameterOfBinaryTree() {
    }

    public static int diameter(TreeNode root) {
        int[] maximum = {0};
        height(root, maximum);
        return maximum[0];
    }

    private static int height(TreeNode node, int[] maximum) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left, maximum);
        int rightHeight = height(node.right, maximum);
        maximum[0] = Math.max(maximum[0], leftHeight + rightHeight);

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
