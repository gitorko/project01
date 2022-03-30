package com.demo.leetcode.medium._11_bstrecover_99;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [99. Recover Binary Search Tree - MEDIUM](https://leetcode.com/problems/recover-binary-search-tree/)
 *
 * - previous, first
 * - no need to swap node.
 *
 * https://www.youtube.com/watch?v=2uPKWpMHmZA&ab_channel=AlgorithmsMadeEasy
 */
public class BSTRecover {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 3, null, null, 2));
        TreeNodeUtil.printTree(root);
        recoverTree(root);
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(Arrays.asList(3, 1, null, null, 2), TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 1, 4, null, null, 2));
        TreeNodeUtil.printTree(root);
        recoverTree(root);
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(Arrays.asList(2, 1, 4, 3), TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    @Test
    public void test3() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 9, 8, null, null, 6, 2));
        TreeNodeUtil.printTree(root);
        recoverTree(root);
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(Arrays.asList(4, 2, 8, 6, 9), TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (first == null || second == null) {
            return;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (first == null && prev != null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val > root.val) {
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
