package com.demo.leetcode.easy._11_btpathsum1_112;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [112. Path Sum - EASY](https://leetcode.com/problems/path-sum/)
 *
 * - dfs, pre-order
 * - reduce target on each recursion
 * - SIMILAR_TO: [113. Path Sum II - MEDIUM](https://leetcode.com/problems/path-sum-ii/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=LSKQyOz_P8I&ab_channel=NeetCode
 */
public class PathSum1BT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1));
        int targetSum = 22;
        Assertions.assertTrue(hasPathSum(root, targetSum));
    }

    /**
     * Time: O(n)
     * Space: O(h) worst case: height=n, balanced binary tree h=log(n)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
