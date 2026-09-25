package dev.daily.dsa;

public final class SymmetricTree {
    private SymmetricTree() {
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || areMirrors(root.left, root.right);
    }

    private static boolean areMirrors(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.value == right.value
                && areMirrors(left.left, right.right)
                && areMirrors(left.right, right.left);
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
