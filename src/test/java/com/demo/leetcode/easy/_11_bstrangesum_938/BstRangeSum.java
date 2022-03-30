package com.demo.leetcode.easy._11_bstrangesum_938;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [938. Range Sum of BST - EASY](https://leetcode.com/problems/range-sum-of-bst/)
 *
 * - bfs
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=Re0QTM4hBuI&ab_channel=NickWhite
 */
public class BstRangeSum {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(10, 5, 15, 3, 7, null, 18));
        int low = 7, high = 15;
        Assertions.assertEquals(32, rangeSumBST(root, low, high));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null && node.val >= low && node.val <= high) {
                sum = sum + node.val;
            }
            if (node.left != null && node.val > low) {
                q.add(node.left);
            }
            if (node.right != null && node.val < high) {
                q.add(node.right);
            }
        }
        return sum;
    }

}
