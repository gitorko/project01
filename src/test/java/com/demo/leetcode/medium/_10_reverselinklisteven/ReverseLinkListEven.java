package com.demo.leetcode.medium._10_reverselinklisteven;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Reverse link list even odd - MEDIUM]()
 *
 * - dummy node
 * - reverse link list
 */
public class ReverseLinkListEven {

    @Test
    public void test() {
        int arr[] = {1, 2, 8, 9, 12, 16};
        int expected[] = {1, 8, 2, 9, 16, 12};
        ListNode rootNode = ListNodeUtil.create(arr);
        ListNodeUtil.display(rootNode);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(reverse(rootNode)));
    }

    @Test
    public void test2() {
        int arr[] = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int expected[] = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        ListNode rootNode = ListNodeUtil.create(arr);
        ListNodeUtil.display(rootNode);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(reverse(rootNode)));
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) {
            if (curr.val % 2 == 0) {
                prev.next = reversePart(curr);
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode reversePart(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode previous = null;
        while (curr != null && curr.val % 2 == 0) {
            ListNode temp = curr.next;
            curr.next = previous;
            previous = curr;
            curr = temp;
        }
        head.next = curr;
        return previous;
    }

}
