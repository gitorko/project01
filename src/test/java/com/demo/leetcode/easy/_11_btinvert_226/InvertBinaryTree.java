package com.demo.leetcode.easy._11_btinvert_226;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNodeUtil;
import com.demo.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [226. Invert Binary Tree - EASY](https://leetcode.com/problems/invert-binary-tree/)
 *
 * - recursion DFS
 * - use temp variable
 *
 * https://www.youtube.com/watch?v=OnSn2XEQ4MY&ab_channel=NeetCode
 */
public class InvertBinaryTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
        List<Integer> expected = Arrays.asList(4, 7, 2, 9, 6, 3, 1);
        List<Integer> actual = TreeNodeUtil.levelOrderTraversal(invertTree(root));
        Assertions.assertEquals(expected, actual);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
