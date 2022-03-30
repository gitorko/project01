package com.demo.leetcode.medium._11_btwidth_662;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [662. Maximum Width of Binary Tree - MEDIUM](https://leetcode.com/problems/maximum-width-of-binary-tree/)
 *
 * - bfs, pair class, deque
 * - index left is 2*i , right is 2*i+1
 * - deque
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=YP_wb6pX0lk&ab_channel=AlgorithmsMadeEasy
 * https://www.youtube.com/watch?v=Y2CKCnQfHJQ&t=16s&ab_channel=AyushiSharma
 */
public class BTWidth {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 3, 2, 5, 7, null, 9));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(4, widthOfBinaryTree(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 3, 2, 5, 3, 9));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(3, widthOfBinaryTree(root));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Deque<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        while (!q.isEmpty()) {
            int level = q.size();
            int start = q.getFirst().value;
            int end = q.getLast().value;
            maxWidth = Math.max(maxWidth, end - start + 1);
            while (level > 0) {
                Pair nodePair = q.poll();
                if (nodePair.node.left != null) q.offer(new Pair(nodePair.node.left, nodePair.value * 2));
                if (nodePair.node.right != null) q.offer(new Pair(nodePair.node.right, nodePair.value * 2 + 1));
                level--;
            }
        }
        return maxWidth;
    }

    public class Pair {
        TreeNode node;
        Integer value;

        public Pair(TreeNode node, Integer value) {
            this.node = node;
            this.value = value;
        }
    }

}
