package com.demo.leetcode.medium._11_bstvalid_98;

import java.util.Arrays;
import java.util.Stack;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [98. Validate Binary Search Tree - MEDIUM](https://leetcode.com/problems/validate-binary-search-tree/)
 *
 * - max,min
 * - recursion
 *
 * PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=s6ATEkipzow&ab_channel=NeetCode
 */
public class CheckIfValidBST {

    @Test
    public void test_isBST() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(2, 1, 3));
        TreeNodeUtil.printTree(root);
        Assertions.assertTrue(isValidBST(root));
        Assertions.assertTrue(isValidBSTIterative(root));
    }

    @Test
    public void test_notBST() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(5, 1, 4, null, null, 3, 6));
        TreeNodeUtil.printTree(root);
        Assertions.assertFalse(isValidBST(root));
        Assertions.assertFalse(isValidBSTIterative(root));
    }

    /**
     * Recursive
     *
     *  start with -MIN for lower boundary, +MAX for upper boundary
     *  if the node is either Integer.MIN_VALUE or Integer.MAX_VALUE then it fails hence use null instead.
     *
     * Time: O(n)
     * Space: O(n)
     *
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        //base case
        if (root == null)
            return true;

        if (min != null && root.val <= min || max != null && root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * Iterative
     * in-order traversal give array in sorted order, so neighbour will be increasing order.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean isValidBSTIterative(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //check if previous is less than current, in-order ascending
            if (previous != null && root.val <= previous.val) return false;
            previous = root;
            root = root.right;
        }
        return true;
    }

}
