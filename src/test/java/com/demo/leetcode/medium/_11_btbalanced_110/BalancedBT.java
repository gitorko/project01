package com.demo.leetcode.medium._11_btbalanced_110;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [110. Balanced Binary Tree - MEDIUM](https://leetcode.com/problems/balanced-binary-tree/)
 *
 * - math.abs, return -1
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=QfJsau0ItOY&ab_channel=NeetCode
 */
public class BalancedBT {

    @Test
    public void test_isBalanced() {
        List<Integer> treeData = Arrays.asList(1, 2, 3, 4, 5);
        TreeNode root = TreeNodeUtil.insertLevelOrder(treeData);
        TreeNodeUtil.printTree(root);
        Assertions.assertTrue(isBalanced2(root));
        Assertions.assertTrue(isBalanced(root));
    }

    @Test
    public void test_isNotBalanced() {
        List<Integer> treeData = Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4);
        TreeNode root = TreeNodeUtil.insertLevelOrder(treeData);
        TreeNodeUtil.printTree(root);
        Assertions.assertFalse(isBalanced2(root));
        Assertions.assertFalse(isBalanced(root));
    }

    /**
     * Bottom up
     * Instead of calling depth() explicitly for each child node, we return the height of the current node in DFS recursion.
     *
     * A -1 indicates its not balanced. A positive number is the height.
     * Ensure you use Math.abs - as not sure which side will be bigger.
     *
     *  Option 1: topdown approach - get depth at each node. Time: O(n^2) not optimal
     *  Option 2: bottom up approach Time: O(n) - return height from bottom.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Not optimal
     * Top down approach. get depth on each node.
     * Ensure you use Math.abs - as not sure which side will be bigger.
     *
     * Time: O(n^2)
     * Space: O(1)
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = getDepth(root.left);
        int rightHeight = getDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced2(root.left) && isBalanced2(root.right))
            return true;
        return false;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
