package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorOfBinarySearchTreeTest {
    @Test
    void findsAncestorWhenTargetsSplitAtRoot() {
        Tree tree = sampleTree();

        assertSame(
                tree.root,
                LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(
                        tree.root, tree.node2, tree.node8));
    }

    @Test
    void returnsTargetWhenItIsAncestorOfOtherTarget() {
        Tree tree = sampleTree();

        assertSame(
                tree.node2,
                LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(
                        tree.root, tree.node2, tree.node4));
    }

    @Test
    void findsAncestorBelowRoot() {
        Tree tree = sampleTree();

        assertSame(
                tree.node4,
                LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(
                        tree.root, tree.node3, tree.node5));
    }

    @Test
    void returnsNodeWhenBothTargetsAreSame() {
        Tree tree = sampleTree();

        assertSame(
                tree.node7,
                LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(
                        tree.root, tree.node7, tree.node7));
    }

    @Test
    void returnsNullForEmptyTree() {
        LowestCommonAncestorOfBinarySearchTree.TreeNode target = node(1);

        assertNull(
                LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(
                        null, target, target));
    }

    private static Tree sampleTree() {
        Tree tree = new Tree();
        tree.root = node(6);
        tree.node2 = node(2);
        tree.node8 = node(8);
        tree.node4 = node(4);
        tree.node3 = node(3);
        tree.node5 = node(5);
        tree.node7 = node(7);

        tree.root.left = tree.node2;
        tree.root.right = tree.node8;
        tree.node2.left = node(0);
        tree.node2.right = tree.node4;
        tree.node4.left = tree.node3;
        tree.node4.right = tree.node5;
        tree.node8.left = tree.node7;
        tree.node8.right = node(9);
        return tree;
    }

    private static LowestCommonAncestorOfBinarySearchTree.TreeNode node(int value) {
        return new LowestCommonAncestorOfBinarySearchTree.TreeNode(value);
    }

    private static final class Tree {
        private LowestCommonAncestorOfBinarySearchTree.TreeNode root;
        private LowestCommonAncestorOfBinarySearchTree.TreeNode node2;
        private LowestCommonAncestorOfBinarySearchTree.TreeNode node8;
        private LowestCommonAncestorOfBinarySearchTree.TreeNode node4;
        private LowestCommonAncestorOfBinarySearchTree.TreeNode node3;
        private LowestCommonAncestorOfBinarySearchTree.TreeNode node5;
        private LowestCommonAncestorOfBinarySearchTree.TreeNode node7;
    }
}
