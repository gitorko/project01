package com.demo.leetcode.medium._11_btroottoleafsum_129;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [129. Sum Root to Leaf Numbers - MEDIUM](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
 *
 * - pre-order with multiply by 10
 * - sum * 10 + root.val
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=Jk16lZGFWxE&ab_channel=NeetCode
 */
public class RootToLeafSumBT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 9, 0, 5, 1));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(1026, sumNumbers(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(25, sumNumbers(root));
    }

    /**
     * Time: O(n)
     * Space: O(h) height of tree
     */
    public int sumNumbers(TreeNode root) {
        return sumTree(root, 0);
    }

    public int sumTree(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        //leaf Node
        if (root.right == null && root.left == null)
            return sum;

        //recurse left + right
        return sumTree(root.left, sum) + sumTree(root.right, sum);
    }
}
