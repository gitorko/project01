package com.demo.leetcode.medium._11_btflatten_114;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [114. Flatten Binary Tree to Linked List - MEDIUM](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
 *
 * - left,right tail
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=rKnD7rLT0lI&ab_channel=NeetCode
 */
public class FlattenBinaryTree {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        flatten(root);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversal(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3));
        List<Integer> expected = Arrays.asList(1, 2, 3);
        flatten(root);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversal(root));
    }

    /**
     * Time: O(n)
     * Space: O(h)
     */
    public void flatten(TreeNode root) {
        dfsFlatten(root);
    }

    /**
     * Returns tail
     */
    private TreeNode dfsFlatten(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftTail = dfsFlatten(root.left);
        TreeNode rightTail = dfsFlatten(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        } else {
            return root;
        }
    }
}
