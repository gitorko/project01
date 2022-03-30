package com.demo.leetcode.easy._13_bstfromarray_108;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [108. Convert Sorted Array to Binary Search Tree - EASY](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
 *
 * - binary search
 * - recursion
 *
 * PRACTICE
 */
public class BinarySearchTreeFromArray {

    @Test
    public void test() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        List<Integer> expected = Arrays.asList(0, -10, 5, null, -3, null, 9);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    /**
     * Time: O(n)
     * Space: O(log(n))
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
