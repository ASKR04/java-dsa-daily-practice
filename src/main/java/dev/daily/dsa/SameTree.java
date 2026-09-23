package dev.daily.dsa;

public final class SameTree {
    private SameTree() {
    }

    public static boolean isSame(TreeNode first, TreeNode second) {
        if (first == null || second == null) {
            return first == second;
        }

        return first.value == second.value
                && isSame(first.left, second.left)
                && isSame(first.right, second.right);
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
