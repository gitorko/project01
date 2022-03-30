package com.demo.leetcode.medium._11_btlca_236;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [236. Lowest Common Ancestor of a Binary Tree - MEDIUM](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
 *
 * - p and q are not guaranteed to exist in the tree
 * - dfs, recursion
 * - if gets not null from left & right then its lca.
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=13m9ZCB8gjw&ab_channel=TusharRoy-CodingMadeSimple
 */
public class FindLCANodeMayExist {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
        Assertions.assertEquals(5, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
    }

    @Test
    public void test_notPresent() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNodeUtil.printTree(root);
        Assertions.assertNull(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(9)));
    }

    @Test
    public void test_onlyOneSide_notPresent() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, null, null));
        TreeNodeUtil.printTree(root);
        Assertions.assertNull(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(6)));
    }

    @Test
    public void test_onlyOneSide_present() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 5, null, 6, null));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(5, lowestCommonAncestor(root, new TreeNode(5), new TreeNode(6)).val);
    }

    boolean v1;
    boolean v2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        v1 = false;
        v2 = false;
        // Find lca of p and q using the technique discussed above
        TreeNode lca = findLCA(root, p, q);
        // if p and q both exists, we can find lca
        // if only one found, other may lie in the subtree of it
        // if no above case satisfies, lca cant be found
        if (v1 && v2 || v1 && find(lca, q) || find(lca, p) && v2) {
            return lca;
        } else {
            return null;
        }
    }

    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val) {
            v1 = true;
            return root;
        }
        if (root.val == q.val) {
            v2 = true;
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    private boolean find(TreeNode root, TreeNode findNode) {
        // Base Case
        if (root == null)
            return false;

        // If key is present at root, or in left subtree or right subtree,
        if (root.val == findNode.val || find(root.left, findNode) || find(root.right, findNode))
            return true;

        // Else return false
        return false;
    }

}
