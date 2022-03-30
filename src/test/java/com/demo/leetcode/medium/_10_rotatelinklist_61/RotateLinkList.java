package com.demo.leetcode.medium._10_rotatelinklist_61;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [61. Rotate List - MEDIUM](https://leetcode.com/problems/rotate-list/)
 *
 * - 3 phases, get the length,check k % len, move len - k, fix list
 *
 * https://www.youtube.com/watch?v=UcGtPs2LE_c&ab_channel=NeetCode
 */
public class RotateLinkList {

    @Test
    public void test() {
        int k = 2;
        int arr1[] = {1, 2, 3, 4, 5};
        int expected[] = {4, 5, 1, 2, 3};
        ListNode r1 = ListNodeUtil.create(arr1);
        ListNode r2 = rotateRight(r1, k);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(r2));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if (head == null || k == 0) {
            return head;
        }

        //get the length of linked list, dont do it in a different function as you need the tail.
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        //if k is greater than lenght then mod
        k = k % len;
        if (k == 0)
            return head;

        //move to pivot to previous node and rotate
        //length - k - 1 as we want to be one node behind.
        ListNode curr = head;
        for (int i = 0; i < len - k - 1; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;

    }

}
