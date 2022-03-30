package com.demo.leetcode.easy._10_reverselinklist_206;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [206. Reverse Linked List - EASY](https://leetcode.com/problems/reverse-linked-list/)
 *
 * - Two pointer - iterative, 1st pointer null, 2nd pointer head, 3rd temp pointer
 * - Recursion - head.next.next
 *
 * PRACTICE
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
     * Iterative - two pointer
     *
     * Time: O(N)
     * Space: O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            //Move both pointers forward.
            previous = current;
            current = temp;
        }
        return previous;
    }

    /**
     * Recursive
     *
     * Time: O(N)
     * Space: O(N)
     */
    public ListNode reverseListRecursion(ListNode head) {
        //base case
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
