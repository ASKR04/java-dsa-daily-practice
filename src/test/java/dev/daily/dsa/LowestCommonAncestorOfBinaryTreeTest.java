package dev.daily.dsa;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorOfBinaryTreeTest {
    @Test
    void findsAncestorWhenTargetsAreOnDifferentSides() {
        Tree tree = sampleTree();

        assertSame(
                tree.root,
                LowestCommonAncestorOfBinaryTree.lowestCommonAncestor(
                        tree.root, tree.node5, tree.node1));
    }

    @Test
    void returnsTargetWhenItIsAncestorOfOtherTarget() {
        Tree tree = sampleTree();

        assertSame(
                tree.node5,
                LowestCommonAncestorOfBinaryTree.lowestCommonAncestor(
                        tree.root, tree.node5, tree.node4));
    }

    @Test
    void findsAncestorInsideOneSubtree() {
        Tree tree = sampleTree();

        assertSame(
                tree.node2,
                LowestCommonAncestorOfBinaryTree.lowestCommonAncestor(
                        tree.root, tree.node7, tree.node4));
    }

    @Test
    void returnsNodeWhenBothTargetsAreSameNode() {
        Tree tree = sampleTree();

        assertSame(
                tree.node7,
                LowestCommonAncestorOfBinaryTree.lowestCommonAncestor(
                        tree.root, tree.node7, tree.node7));
    }

    @Test
    void handlesEmptyTree() {
        LowestCommonAncestorOfBinaryTree.TreeNode first = node(1);
        LowestCommonAncestorOfBinaryTree.TreeNode second = node(2);

        assertNull(LowestCommonAncestorOfBinaryTree.lowestCommonAncestor(null, first, second));
    }

    private static Tree sampleTree() {
        Tree tree = new Tree();
        tree.root = node(3);
        tree.node5 = node(5);
        tree.node1 = node(1);
        tree.node2 = node(2);
        tree.node7 = node(7);
        tree.node4 = node(4);

        tree.root.left = tree.node5;
        tree.root.right = tree.node1;
        tree.node5.left = node(6);
        tree.node5.right = tree.node2;
        tree.node1.left = node(0);
        tree.node1.right = node(8);
        tree.node2.left = tree.node7;
        tree.node2.right = tree.node4;
        return tree;
    }

    private static LowestCommonAncestorOfBinaryTree.TreeNode node(int value) {
        return new LowestCommonAncestorOfBinaryTree.TreeNode(value);
    }

    private static final class Tree {
        private LowestCommonAncestorOfBinaryTree.TreeNode root;
        private LowestCommonAncestorOfBinaryTree.TreeNode node5;
        private LowestCommonAncestorOfBinaryTree.TreeNode node1;
        private LowestCommonAncestorOfBinaryTree.TreeNode node2;
        private LowestCommonAncestorOfBinaryTree.TreeNode node7;
        private LowestCommonAncestorOfBinaryTree.TreeNode node4;
    }
}
