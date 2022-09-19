package com.demo.leetcode.easy._11_stringfrombt_606;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [606. Construct String from Binary Tree - EASY](https://leetcode.com/problems/construct-string-from-binary-tree/)
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
        if (root == null) return "";

        String result = root.val + "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (left.equals("") && right.equals("")) return result;
        if (left.equals("")) return result + "()" + "(" + right + ")";
        if (right.equals("")) return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
