package com.demo.leetcode.medium._11_convertbstgreatertree_538;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [538. Convert BST to Greater Tree - MEDIUM](https://leetcode.com/problems/convert-bst-to-greater-tree/)
 *
 * - reverse inorder (right -> root -> left)
 * - PRACTICE: P4
 *
 * https://www.youtube.com/watch?v=7vVEJwVvAlI&ab_channel=NeetCode
 */
public class ConvertBSTGreaterTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
        List<Integer> expected = Arrays.asList(30, 36, 21, 36, 35, 26, 15, null, 33, null, 8);
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(convertBST(root)));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public TreeNode convertBST(TreeNode root) {
        reversedInorder(root);
        return root;
    }

    int sum = 0;

    private void reversedInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        reversedInorder(root.right);
        sum += root.val;
        root.val = sum;
        reversedInorder(root.left);
    }
}
