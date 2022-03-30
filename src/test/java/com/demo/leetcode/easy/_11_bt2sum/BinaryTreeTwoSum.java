package com.demo.leetcode.easy._11_bt2sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Binary Tree two sum different level - EASY]()
 *
 * - Given a binary tree and an integer K, return two nodes which are at different level and their sum is equal to K.
 * - Tree can have duplicate values.
 * - In case more than one pair is available in the tree, then return any of the pair.
 */
public class BinaryTreeTwoSum {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, 4, 5));
        TreeNodeUtil.printTree(root);
        List<TreeNode> result = twoSum(root, 7);
        Assertions.assertEquals(4, result.get(0).val);
        Assertions.assertEquals(3, result.get(1).val);
    }

    public List<TreeNode> twoSum(TreeNode root, int k) {
        if (root == null) return List.of();

        Map<Integer, TreeNode> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Map<Integer, TreeNode> levelMap = new HashMap<>();
            int size = q.size();
            while (size > 0) {
                TreeNode curr = q.poll();
                int complement = k - curr.val;
                if (visited.containsKey(complement)) {
                    return List.of(curr, visited.get(complement));
                }
                levelMap.put(curr.val, curr);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                size--;
            }
            visited.putAll(levelMap);
        }
        return List.of();
    }
}
