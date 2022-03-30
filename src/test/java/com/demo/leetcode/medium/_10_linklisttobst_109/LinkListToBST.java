package com.demo.leetcode.medium._10_linklisttobst_109;

import com.demo.common.ListNode;
import com.demo.common.TreeNode;

/**
 * [109. Convert Sorted List to Binary Search Tree - MEDIUM](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)
 *
 * - find mid
 * - recursion
 *
 * PRACTICE
 */
public class LinkListToBST {

    /**
     * Time: O(n*log(n))
     * Space: O(log(n))
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //break before mid
        prev.next = null;
        return slow;
    }
}
