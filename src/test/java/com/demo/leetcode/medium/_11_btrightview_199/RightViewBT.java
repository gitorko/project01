package com.demo.leetcode.medium._11_btrightview_199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [199. Binary Tree Right Side View - MEDIUM](https://leetcode.com/problems/binary-tree-right-side-view/)
 *
 * - bfs
 *
 * https://www.youtube.com/watch?v=d4zLyf32e3I&ab_channel=NeetCode
 */
public class RightViewBT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, null, 5, null, 4));
        List<Integer> expected = Arrays.asList(1, 3, 4);
        Assertions.assertEquals(expected, rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        TreeNode rightNode = null;
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                rightNode = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            result.add(rightNode.val);
        }
        return result;
    }
}
