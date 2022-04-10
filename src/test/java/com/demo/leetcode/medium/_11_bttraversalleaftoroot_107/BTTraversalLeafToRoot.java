package com.demo.leetcode.medium._11_bttraversalleaftoroot_107;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [107. Binary Tree Level Order Traversal II - MEDIUM](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
 *
 * - bfs
 */
public class BTTraversalLeafToRoot {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7));
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3));
        Assertions.assertEquals(expected, levelOrderBottom(root));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                subList.add(node.val);
                size--;
            }
            result.add(0, subList);
        }

        return result;
    }
}
