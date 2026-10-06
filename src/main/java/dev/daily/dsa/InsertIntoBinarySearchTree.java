package dev.daily.dsa;

public final class InsertIntoBinarySearchTree {
    private InsertIntoBinarySearchTree() {
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        TreeNode current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new TreeNode(value);
                    return root;
                }
                current = current.left;
            } else if (value > current.value) {
                if (current.right == null) {
                    current.right = new TreeNode(value);
                    return root;
                }
                current = current.right;
            } else {
                throw new IllegalArgumentException("duplicate values are not allowed");
            }
        }
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
