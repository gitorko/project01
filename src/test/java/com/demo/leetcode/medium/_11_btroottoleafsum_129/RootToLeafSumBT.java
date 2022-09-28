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
 * - PRACTICE: P2
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
        if(root == null) {
            return 0;
        }

        //base case
        if(root.left == null && root.right == null) {
            return sum + root.val;
        }

        int leftSum = sumTree(root.left, (sum + root.val) * 10);
        int rightSum = sumTree(root.right, (sum + root.val) * 10);

        return leftSum + rightSum;
    }
}
