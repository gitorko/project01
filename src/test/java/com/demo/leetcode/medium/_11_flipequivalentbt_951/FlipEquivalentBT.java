package com.demo.leetcode.medium._11_flipequivalentbt_951;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [951. Flip Equivalent Binary Trees - MEDIUM](https://leetcode.com/problems/flip-equivalent-binary-trees/)
 *
 * - recursion
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=izRDc1il9Pk&ab_channel=NeetCode
 */
public class FlipEquivalentBT {

    @Test
    public void test1() {
        TreeNode root1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, null, null, null, 7, 8));
        TreeNode root2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7));
        Assertions.assertTrue(flipEquiv(root1, root2));
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
