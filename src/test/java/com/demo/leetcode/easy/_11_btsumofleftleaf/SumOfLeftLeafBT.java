package com.demo.leetcode.easy._11_btsumofleftleaf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [404. Sum of Left Leaves - EASY](https://leetcode.com/problems/sum-of-left-leaves/)
 *
 * - recursive, DFS
 * - BFS
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=TzkfuLgpUxc&ab_channel=NickWhite
 */
public class SumOfLeftLeafBT {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(24, sumOfLeftLeaves(root));
        Assertions.assertEquals(24, sumOfLeftLeavesIterative(root));
    }

    /**
     * bfs
     */
    public int sumOfLeftLeavesIterative(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null && curr.left.left == null && curr.left.right == null) result += curr.left.val;
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return result;
    }

    /**
     * dfs
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        //simply adding the right node will be enough here as the null check ensures 0 is returned.
        //case1: right node is null
        //case2: right node has children
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }

}
