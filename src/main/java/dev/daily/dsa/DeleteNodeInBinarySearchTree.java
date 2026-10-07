package dev.daily.dsa;

public final class DeleteNodeInBinarySearchTree {
    private DeleteNodeInBinarySearchTree() {
    }

    public static TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.value) {
            root.left = delete(root.left, key);
            return root;
        }
        if (key > root.value) {
            root.right = delete(root.right, key);
            return root;
        }

        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        TreeNode successor = minimum(root.right);
        successor.right = deleteMinimum(root.right);
        successor.left = root.left;
        return successor;
    }

    private static TreeNode minimum(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private static TreeNode deleteMinimum(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMinimum(node.left);
        return node;
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
