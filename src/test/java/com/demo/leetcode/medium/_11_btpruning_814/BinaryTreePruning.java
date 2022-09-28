package com.demo.leetcode.medium._11_btpruning_814;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [814. Binary Tree Pruning - MEDIUM](https://leetcode.com/problems/binary-tree-pruning/)
 *
 * - pre-order traversal
 * - PRACTICE: P3
 * - MISTAKES: Likely to miss edge case when all nodes are 0.
 */
public class BinaryTreePruning {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, null, 0, 0, 1));
        List<Integer> expected = Arrays.asList(1, null, 0, null, 1);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(pruneTree(root)));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 0, 1, 0, 0, 0, 1));
        List<Integer> expected = Arrays.asList(1, null, 1, null, 1);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(pruneTree(root)));
    }

    @Test
    public void test3() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(0, null, 0, 0, 0));
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList();
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(pruneTree(root)));
    }

    public TreeNode pruneTree(TreeNode root) {
        boolean present = dfs(root);
        if (!present) root = null;
        return root;
    }

    public boolean dfs(TreeNode root) {
        //base case
        if (root == null) {
            return false;
        }

        boolean leftPresent = dfs(root.left);
        if (!leftPresent) root.left = null;

        boolean rightPresent = dfs(root.right);
        if (!rightPresent) root.right = null;

        boolean rootPresent = root.val == 1 ? true : false;
        return rootPresent || leftPresent || rightPresent;
    }
}
