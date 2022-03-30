package com.demo.leetcode.medium._11_btlca_236;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [236. Lowest Common Ancestor of a Binary Tree - MEDIUM](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
 *
 * - p and q are guaranteed to exist in the tree
 * - dfs, recursion
 * - if gets not null from left & right then its lca.
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=13m9ZCB8gjw&ab_channel=TusharRoy-CodingMadeSimple
 */
public class FindLCANodeExist {

    @Test
    public void test_nodesOnDiffSide() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
    }

    @Test
    public void test_bothNodesOnSameSide() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 6, 2));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(5, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(6)).val);
    }

    /**
     * Recursion - if gets not null from left & right then its lca.
     * Time: O(n)
     * Space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

}
