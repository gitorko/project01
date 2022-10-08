package com.demo.leetcode.easy._11_btsametree_100;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [100. Same Tree - EASY](https://leetcode.com/problems/same-tree/)
 *
 * - recursion
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=vRbbcKXCxOw&ab_channel=NeetCode
 */
public class SameTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3));
        TreeNode subRoot = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3));
        Assertions.assertTrue(isSameTree(root, subRoot));
    }

    @Test
    public void test_sameTree_oneLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    @Test
    public void test_notSameTree_oneLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 2));
        Assertions.assertFalse(isSameTree(t1, t2));
    }

    @Test
    public void test_sameTree_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, 4, 8, 9));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, 4, 8, 9));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    @Test
    public void test_NotSameTree_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, 4, 8, 9));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, 4, 8));
        Assertions.assertFalse(isSameTree(t1, t2));
    }

    @Test
    public void test_sameTree_leftNodeNull_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, 4, null, 9));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, 4, null, 9));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    @Test
    public void test_sameTree_rightNodeNull_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, null, 8, 9));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 2, null, 8, 9));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    @Test
    public void test_sameTree_leftSide_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, null, 2, 4));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, null, 2, 4));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    @Test
    public void test_sameTree_rightSide_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, null, 1, 8, 9));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, null, 1, 8, 9));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    /**
     * Only one node
     */
    @Test
    public void test_sameTree_oneNode_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3));
        Assertions.assertTrue(isSameTree(t1, t2));
    }

    /**
     * One node is null
     */
    @Test
    public void test_sameTree_oneNullNode_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3));
        TreeNode t2 = null;
        Assertions.assertFalse(isSameTree(t1, t2));
    }

    /**
     * In-order traversal is same but trees not same.
     */
    @Test
    public void test_sameTree_sameInorder_twoLevel() {
        TreeNode t1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 2, null, 1));
        TreeNode t2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(2, 1, 3));
        System.out.println(TreeNodeUtil.inorderTraversal(t1));
        System.out.println(TreeNodeUtil.inorderTraversal(t2));
        Assertions.assertFalse(isSameTree(t1, t2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
