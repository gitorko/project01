package com.demo.leetcode.medium._11_deletenodebst_450;


import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [450. Delete Node in a BST - MEDIUM](https://leetcode.com/problems/delete-node-in-a-bst/)
 *
 * https://www.youtube.com/watch?v=LFzAoJJt92M&ab_channel=NeetCodeIO
 */
public class DeleteNodeBST {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(5, 3, 6, 2, 4, null, 7));
        int key = 3;
        List<Integer> expected = Arrays.asList(5, 4, 6, 2, null, null, 7);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(deleteNode(root, key)));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            //delete the right node
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
