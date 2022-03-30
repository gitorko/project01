package com.demo.leetcode.easy._11_btdepth;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Get size of binary tree - EASY]()
 *
 * - recursion, pre-order dfs
 *
 * https://www.youtube.com/watch?v=NA8B84DZYSA&ab_channel=TusharRoy-CodingMadeSimple
 */
public class SizeBT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 6, 2, 0, 8));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(7, getSize(root));
    }

    /**
     * Time: O(n)
     * Space: O(n) - height of bt
     */
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSize(root.left);
        int right = getSize(root.right);
        return left + right + 1;
    }
}
