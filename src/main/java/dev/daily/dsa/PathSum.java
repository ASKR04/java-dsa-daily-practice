package dev.daily.dsa;

public final class PathSum {
    private PathSum() {
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int remaining = targetSum - root.value;
        if (root.left == null && root.right == null) {
            return remaining == 0;
        }

        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);
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
