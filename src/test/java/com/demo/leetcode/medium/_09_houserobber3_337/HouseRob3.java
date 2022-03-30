package com.demo.leetcode.medium._09_houserobber3_337;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [337. House Robber III - MEDIUM](https://leetcode.com/problems/house-robber-iii/)
 *
 * - withRoot,withoutRoot, post-order
 * - dfs post-order traversal
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=nHR8ytpzz7c&ab_channel=NeetCode
 */
public class HouseRob3 {

    @Test
    public void test() {
        List<Integer> treeData = Arrays.asList(3, 2, 3, null, 3, null, 1);
        TreeNode root = TreeNodeUtil.insertLevelOrder(treeData);
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(7, robHouse(root));
    }

    /**
     * Time: O(N)
     */
    public int robHouse(TreeNode root) {
        Result result = dfs(root);
        return Math.max(result.withRoot, result.withoutRoot);
    }

    public Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        Result leftPair = dfs(root.left);
        Result rightPair = dfs(root.right);
        int withRoot = root.val + leftPair.withoutRoot + rightPair.withoutRoot;
        int withoutRoot = Math.max(leftPair.withoutRoot, leftPair.withRoot) + Math.max(rightPair.withoutRoot, rightPair.withRoot);
        return new Result(withRoot, withoutRoot);
    }

    @AllArgsConstructor
    class Result {
        int withRoot;
        int withoutRoot;
    }
}


