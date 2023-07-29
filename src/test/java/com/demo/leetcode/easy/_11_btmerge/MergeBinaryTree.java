package com.demo.leetcode.easy._11_btmerge;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [617. Merge Two Binary Trees - EASY](https://leetcode.com/problems/merge-two-binary-trees/)
 *
 * - recursion
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=QHH6rIK3dDQ&ab_channel=NeetCode
 */
public class MergeBinaryTree {

    @Test
    public void test() {
        TreeNode root1 = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 3, 2, 5));
        TreeNode root2 = TreeNodeUtil.insertLevelOrder(Arrays.asList(2, 1, 3, null, 4, null, 7));
        TreeNode result = mergeTrees(root1, root2);
        List<Integer> expected = Arrays.asList(3, 4, 5, 5, 4, null, 7);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(result));
    }

    /**
     * Time: O(m+n)
     * new tree created
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else {
            int v1 = root1 != null ? root1.val : 0;
            int v2 = root2 != null ? root2.val : 0;
            TreeNode root = new TreeNode(v1 + v2);
            root.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
            root.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
            return root;
        }
    }

    /**
     * Time: O(m+n)
     * In place merge
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees2(root1.left, root2.left);
            root1.right = mergeTrees2(root1.right, root2.right);
        } else if (root1 != null && root2 == null) {
            root1.left = mergeTrees2(root1.left, null);
            root1.right = mergeTrees2(root1.right, null);
        } else if (root1 == null && root2 != null) {
            root1 = root2;
            root1.right = mergeTrees2(null, root2.right);
            root1.right = mergeTrees2(null, root2.right);
        }
        return root1;
    }
}
