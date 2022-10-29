package com.demo.leetcode.hard._11_binarytreeserialize_297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [297. Serialize and Deserialize Binary Tree - HARD](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
 *
 * - pre-order, queue
 * - recursion
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=u4JAi2JJhI8&ab_channel=NeetCode
 */
public class SerializeBinaryTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, null, null, 4, 5));
        TreeNodeUtil.printTree(root);
        String serialize = serialize(root);
        Assertions.assertEquals("1,2,#,#,3,4,#,#,5,#,#", serialize);
        TreeNode resultRoot = deserialize(serialize);
        TreeNodeUtil.printTree(resultRoot);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversal(resultRoot));
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
