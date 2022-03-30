package com.demo.leetcode.medium._11_bstkthsmall_230;

import java.util.Arrays;
import java.util.Stack;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [230. Kth Smallest Element in a BST - MEDIUM](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
 *
 * - Iterative in-order traversal using stack
 * - brute force: in-order traversal and the kth element in sorted array is result.
 *
 * https://www.youtube.com/watch?v=5LUXSvjmGCw&ab_channel=NeetCode
 */
public class KthSmallestBST {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, kthSmallest(root, 3));
    }

    /**
     * Iterative - in-order traversal
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //go to left node as deep as possible
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
