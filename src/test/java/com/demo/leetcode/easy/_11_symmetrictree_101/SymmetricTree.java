package com.demo.leetcode.easy._11_symmetrictree_101;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [101. Symmetric Tree - EASY](https://leetcode.com/problems/symmetric-tree/)
 *
 * - dfs, recursion
 *
 * PRACTICE
 */
public class SymmetricTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 2, 3, 4, 4, 3));
        TreeNodeUtil.printTree(root);
        Assertions.assertTrue(isSymmetric(root));
        Assertions.assertTrue(isSymmetric2(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        if (a.val != b.val)
            return false;

        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

    /**
     * BFS - push both nodes to queue. order matters
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}
