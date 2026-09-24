package dev.daily.dsa;

public final class InvertBinaryTree {
    private InvertBinaryTree() {
    }

    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode originalLeft = root.left;
        root.left = invert(root.right);
        root.right = invert(originalLeft);
        return root;
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
