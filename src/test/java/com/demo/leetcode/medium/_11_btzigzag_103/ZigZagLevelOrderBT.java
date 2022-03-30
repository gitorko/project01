package com.demo.leetcode.medium._11_btzigzag_103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [103. Binary Tree Zigzag Level Order Traversal - MEDIUM](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
 *
 * - deque, bfs
 * - BFS, on even odd level reverse list and add to result.
 */
public class ZigZagLevelOrderBT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7));
        TreeNodeUtil.printTree(root);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7));
        Assertions.assertEquals(expected, zigzagLevelOrder(root));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        boolean even = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (levelNum > 0) {
                if (even) {
                    TreeNode node = queue.pollFirst();
                    subList.add(node.val);
                    if (node.left != null)
                        queue.addLast(node.left);
                    if (node.right != null)
                        queue.addLast(node.right);
                } else {
                    TreeNode node = queue.pollLast();
                    subList.add(node.val);
                    if (node.right != null)
                        queue.addFirst(node.right);
                    if (node.left != null)
                        queue.addFirst(node.left);
                }
                levelNum--;
            }
            even = !even;
            result.add(subList);
        }
        return result;
    }

}
