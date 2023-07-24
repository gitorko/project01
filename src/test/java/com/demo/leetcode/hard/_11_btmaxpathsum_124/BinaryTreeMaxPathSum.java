package com.demo.leetcode.hard._11_btmaxpathsum_124;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [124. Binary Tree Maximum Path Sum - HARD](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
 *
 * - with fork, without fork value
 * - if negative set to zero
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Hr5cWUld4vU&ab_channel=NeetCode
 */
public class BinaryTreeMaxPathSum {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(-10, 9, 20, null, null, 15, 7));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(42, maxPathSum(root));
    }

    /**
     * Time: O(n)
     * Space: O(h)
     */
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //If negative set to 0.
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        //with fork
        maxValue = Math.max(maxValue, left + right + node.val);
        //without fork
        return node.val + Math.max(left, right);
    }
}
