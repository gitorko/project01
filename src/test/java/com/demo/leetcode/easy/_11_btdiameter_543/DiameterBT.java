package com.demo.leetcode.easy._11_btdiameter_543;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [543. Diameter of Binary Tree - EASY](https://leetcode.com/problems/diameter-of-binary-tree/)
 *
 * - post order traversal
 * - max height (left + right) + 1
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=bkxqA8Rfv04&ab_channel=NeetCode
 */
public class DiameterBT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, 4, 5));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, diameterOfBinaryTree(root));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    int maxVal = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxVal;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxVal = Math.max(maxVal, left + right);
        return Math.max(left, right) + 1;
    }
}
