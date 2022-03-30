package com.demo.leetcode.easy._11_btdepth;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Get height of binary tree - EASY]()
 *
 * - recursion - dfs, pre-order traversal
 *
 * https://www.youtube.com/watch?v=_SiwrPXG9-g&ab_channel=TusharRoy-CodingMadeSimple
 */
public class HeightBT {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 6, 2, 0, 8));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, getHeight(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(4, getHeight(root));
    }

    /**
     * A node’s height is the number of edges to its most distant leaf node.
     * On the other hand, a node’s depth is the number of edges back up to the root.
     * The root always has a depth of 0 while leaf nodes always have a height of 0.
     *
     * Time : O(n)
     * Space: O(n) - height of bt
     */
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
