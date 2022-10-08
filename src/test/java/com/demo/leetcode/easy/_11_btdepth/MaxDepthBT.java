package com.demo.leetcode.easy._11_btdepth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [104. Maximum Depth of Binary Tree - EASY](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
 *
 * - recursion, dfs pre-order traversal
 * - max depth = height of tree
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=hTM3phVI6YQ&ab_channel=NeetCode
 */
public class MaxDepthBT {

    @Test
    public void test() {
        List<Integer> treeData = Arrays.asList(3, 9, 20, null, null, 15, 7);
        TreeNode root = TreeNodeUtil.insertLevelOrder(treeData);
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, maxDepth(root));
        Assertions.assertEquals(3, maxDepth2(root));
    }

    /**
     * Recursive
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    /**
     * Iterative - BFS
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
        }
        return level;
    }
}
