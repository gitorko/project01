package com.demo.leetcode.medium._07_btpathsum2_113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [113. Path Sum II - MEDIUM](https://leetcode.com/problems/path-sum-ii/)
 *
 * - dfs, preorder + backtracking + remove from path
 * - remember to reduce target on each recursion
 * - remember to remove node from path
 *
 * PRACTICE
 */
public class PathSum2BT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5));
        Assertions.assertEquals(expected, pathSum(root, 22));

        root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3));
        expected = Arrays.asList(Arrays.asList(1, 2));
        Assertions.assertEquals(expected, pathSum(root, 3));
    }

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        //Leaf node reached & target matches
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }
    }
}
