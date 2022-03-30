package com.demo.leetcode.easy._11_btpath_257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [257. Binary Tree Paths - EASY](https://leetcode.com/problems/binary-tree-paths/)
 *
 * - pre-order
 */
public class BinaryTreePath {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, null, 5));
        List<String> actual = binaryTreePaths(root);
        List<String> expected = Arrays.asList("1->2->5", "1->3");
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Time: O(n)
     */
    List<String> answer;

    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        if (root != null) searchBT(root, "");
        return answer;
    }

    private void searchBT(TreeNode root, String path) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->");
        if (root.right != null) searchBT(root.right, path + root.val + "->");
    }
}
