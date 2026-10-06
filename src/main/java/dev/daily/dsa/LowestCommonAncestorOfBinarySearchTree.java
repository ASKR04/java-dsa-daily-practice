package dev.daily.dsa;

public final class LowestCommonAncestorOfBinarySearchTree {
    private LowestCommonAncestorOfBinarySearchTree() {
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        int lowerValue = Math.min(first.value, second.value);
        int upperValue = Math.max(first.value, second.value);
        TreeNode current = root;

        while (current != null) {
            if (upperValue < current.value) {
                current = current.left;
            } else if (lowerValue > current.value) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
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
