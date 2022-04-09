package com.demo.leetcode.medium._11_trimbst_669;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [669. Trim a Binary Search Tree - MEDIUM](https://leetcode.com/problems/trim-a-binary-search-tree/)
 *
 * - bst, hence if left is less than low go right. right is greater than high go left.
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=jwt5mTjEXGc&ab_channel=NeetCode
 */
public class TrimBST {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 0, 2));
        List<Integer> expected = Arrays.asList(1, null, 2);
        TreeNodeUtil.printTree(root);
        root = trimBST(root, 1, 2);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 1, 4, null, 2));
        List<Integer> expected = Arrays.asList(1, null, 2);
        TreeNodeUtil.printTree(root);
        root = trimBST(root, 1, 2);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    /**
     * Time: O(n)
     * Space: O(h)
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        //everything on left is less than low so return right.
        if (root.val < low)
            return trimBST(root.right, low, high);
        //everything on right is higher than high so return right.
        if (root.val > high)
            return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
