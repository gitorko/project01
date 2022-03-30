package com.demo.leetcode.easy._11_btsecondmin_671;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [671. Second Minimum Node In a Binary Tree - EASY](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)
 *
 * - root.val = min(root.left.val, root.right.val)
 * - first min is always root.val because the condition defined is
 */
public class SecondMinBT {

    @Test
    public void test() {
        List<Integer> treeData = Arrays.asList(2, 2, 5, null, null, 5, 7);
        TreeNode root = TreeNodeUtil.insertLevelOrder(treeData);
        Assertions.assertEquals(5, findSecondMinimumValue(root));
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        return findSecondMinimumValue(root, root.val);
    }

    private int findSecondMinimumValue(TreeNode root, int min) {
        if (root == null)
            return -1;
        if (root.val > min)
            return root.val;

        int leftMin = findSecondMinimumValue(root.left, min);
        int rightMin = findSecondMinimumValue(root.right, min);

        if (leftMin == -1 || rightMin == -1)
            return Math.max(leftMin, rightMin);
        return Math.min(leftMin, rightMin);
    }
}
