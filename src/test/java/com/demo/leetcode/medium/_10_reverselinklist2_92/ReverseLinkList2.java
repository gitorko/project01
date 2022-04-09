package com.demo.leetcode.medium._10_reverselinklist2_92;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [92. Reverse Linked List II - MEDIUM](https://leetcode.com/problems/reverse-linked-list-ii/)
 *
 * - Dummy head pointer, with 3 pointers, leftPrev
 * - 3 phases
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=RF_M9tX4Eag&ab_channel=NeetCode
 */
public class ReverseLinkList2 {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5};
        int expected[] = {1, 4, 3, 2, 5};
        ListNode rootNode = ListNodeUtil.create(arr);
        reverseBetween(rootNode, 2, 4);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        // create a dummy node to mark the head of this list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // move pointer till it reaches left node.
        ListNode leftPrev = dummy;
        ListNode curr = head;
        for (int i = 0; i < left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }

        //reverse list for given window
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        //fix pointers
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }

}
