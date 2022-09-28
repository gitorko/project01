package com.demo.leetcode.easy._11_stringfrombt_606;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [606. Construct String from Binary Tree - EASY](https://leetcode.com/problems/construct-string-from-binary-tree/)
 *
 * - pre-order traversal
 * - PRACTICE: P4
 *
 * https://www.youtube.com/watch?v=b1WpYxnuebQ&ab_channel=NeetCode
 */
public class StringFromBT {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, 4));
        Assertions.assertEquals("1(2(4))(3)", tree2str(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, null, 4));
        Assertions.assertEquals("1(2()(4))(3)", tree2str(root));
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        if (root.left != null && root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        if (root.left == null && root.right != null) {
            return root.val + "()" + "(" + tree2str(root.right) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
    }
}
