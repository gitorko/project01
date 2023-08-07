package com.demo.leetcode.medium._11_insertnodebst_701;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [701. Insert into a Binary Search Tree - MEDIUM](https://leetcode.com/problems/insert-into-a-binary-search-tree/)
 *
 * https://www.youtube.com/watch?v=LFzAoJJt92M&ab_channel=NeetCodeIO
 */
public class InsertNodeBST {
    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 2, 7, 1, 3));
        int val = 5;
        List<Integer> expected = Arrays.asList(4, 2, 7, 1, 3, 5);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(insertIntoBST(root, val)));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
