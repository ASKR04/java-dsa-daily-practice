package dev.daily.dsa;

public final class LowestCommonAncestorOfBinaryTree {
    private LowestCommonAncestorOfBinaryTree() {
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null || root == first || root == second) {
            return root;
        }

        TreeNode leftResult = lowestCommonAncestor(root.left, first, second);
        TreeNode rightResult = lowestCommonAncestor(root.right, first, second);

        if (leftResult != null && rightResult != null) {
            return root;
        }
        return leftResult != null ? leftResult : rightResult;
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
