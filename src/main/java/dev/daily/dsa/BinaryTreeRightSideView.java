package dev.daily.dsa;

import java.util.ArrayList;
import java.util.List;

public final class BinaryTreeRightSideView {
    private BinaryTreeRightSideView() {
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        collectRightmost(root, 0, view);
        return view;
    }

    private static void collectRightmost(TreeNode node, int depth, List<Integer> view) {
        if (node == null) {
            return;
        }

        if (depth == view.size()) {
            view.add(node.value);
        }

        collectRightmost(node.right, depth + 1, view);
        collectRightmost(node.left, depth + 1, view);
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
