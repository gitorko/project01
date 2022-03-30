package com.demo.leetcode.easy._11_bstlca_235;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [235. Lowest Common Ancestor of a Binary Search Tree - EASY](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
 *
 * - recursion dfs
 * - if there is a split then that node is the lca.
 *
 * https://www.youtube.com/watch?v=gs2LMfuOR9k&ab_channel=NeetCode
 */
public class FindLCAinBST {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(8, lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9)).val);
        Assertions.assertEquals(8, lowestCommonAncestorIterative(root, new TreeNode(7), new TreeNode(9)).val);

        Assertions.assertEquals(6, lowestCommonAncestor(root, new TreeNode(7), new TreeNode(4)).val);
        Assertions.assertEquals(6, lowestCommonAncestorIterative(root, new TreeNode(7), new TreeNode(4)).val);
    }

    /**
     * Recursion
     * Time: O(log(n)) - height of tree.
     * Space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * Iterative
     */
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }

}
