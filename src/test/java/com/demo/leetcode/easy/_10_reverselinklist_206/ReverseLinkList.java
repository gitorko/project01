package com.demo.leetcode.easy._10_reverselinklist_206;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [206. Reverse Linked List - EASY](https://leetcode.com/problems/reverse-linked-list/)
 *
 * - Iterative - prev node
 * - Recursion - head.next.next
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=G0_I-ZF0S38&ab_channel=NeetCode
 */
public class ReverseLinkList {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5};
        int expected[] = {5, 4, 3, 2, 1};
        ListNode rootNode = ListNodeUtil.create(arr);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(reverseList(rootNode)));
        rootNode = ListNodeUtil.create(arr);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(reverseListRecursion(rootNode)));
    }

    /**
     * Iterative
     *
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * Recursive
     *
     * Time: O(n)
     * Space: O(n)
     */
    public ListNode reverseListRecursion(ListNode head) {
        //base case, when one node or zero nodes are given
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
