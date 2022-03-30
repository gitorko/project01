package com.demo.leetcode.medium._11_btpathsum3_437;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [437. Path Sum III - MEDIUM](https://leetcode.com/problems/path-sum-iii/)
 *
 * - dfs return 1,0
 */
public class PathSum3BT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1));
        Assertions.assertEquals(3, pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return (targetSum == root.val ? 1 : 0) +
                dfs(root.left, targetSum - root.val) +
                dfs(root.right, targetSum - root.val);
    }
}
