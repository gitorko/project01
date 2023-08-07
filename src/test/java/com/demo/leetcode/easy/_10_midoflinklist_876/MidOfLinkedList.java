package com.demo.leetcode.easy._10_midoflinklist_876;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [876. Middle of the Linked List - EASY](https://leetcode.com/problems/middle-of-the-linked-list/)
 *
 * https://www.youtube.com/watch?v=A2_ldqM4QcY&ab_channel=NeetCodeIO
 */
public class MidOfLinkedList {

    @Test
    public void test1() {
        int arr[] = {1, 2, 3, 4, 5};
        int expected[] = {3, 4, 5};
        ListNode head = ListNodeUtil.create(arr);
        ListNode result = middleNode(head);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(result));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //for even length list fast pointer will reach last node.
        //for odd length list fast pointer will reach null node.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
