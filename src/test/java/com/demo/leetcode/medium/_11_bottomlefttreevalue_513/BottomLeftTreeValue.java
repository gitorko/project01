package com.demo.leetcode.medium._11_bottomlefttreevalue_513;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [513. Find Bottom Left Tree Value - MEDIUM](https://leetcode.com/problems/find-bottom-left-tree-value/)
 *
 * - bfs
 *
 * https://www.youtube.com/watch?v=u_by_cTsNJA&ab_channel=NeetCode
 */
public class BottomLeftTreeValue {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, 4, null, 5, 6, null, null, 7));
        Assertions.assertEquals(7, findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
        }
        return node.val;
    }
}
