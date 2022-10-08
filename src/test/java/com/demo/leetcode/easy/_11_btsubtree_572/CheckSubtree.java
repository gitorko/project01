package com.demo.leetcode.easy._11_btsubtree_572;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [572. Subtree of Another Tree - EASY](https://leetcode.com/problems/subtree-of-another-tree/)
 *
 * - pre-order traversal won't work unless null node is replaced.
 * - SIMILAR_TO: [100. Same Tree - EASY](https://leetcode.com/problems/same-tree/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=E36O5SWp-LE&ab_channel=NeetCode
 */
public class CheckSubtree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 4, 5, 1, 2));
        TreeNode subRoot = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 1, 2));
        Assertions.assertTrue(isSubtree(root, subRoot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true; //empty tree is subRoot.
        } else if (root == null) {
            return false; //big tree empty
        } else if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
