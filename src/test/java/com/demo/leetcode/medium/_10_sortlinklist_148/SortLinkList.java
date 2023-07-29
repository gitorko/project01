package com.demo.leetcode.medium._10_sortlinklist_148;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [148. Sort List - MEDIUM](https://leetcode.com/problems/sort-list/)
 *
 * - find mid, merge sort, previous node
 * - merge 2 list
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=TGveA1oFhrc&ab_channel=NeetCode
 */
public class SortLinkList {

    @Test
    public void test() {
        ListNode root = ListNodeUtil.create(Arrays.asList(4, 2, 1, 3));
        root = sortList(root);
        int[] expected = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(root));
    }

    /**
     * Time: O(n * log(n))
     * Space: O(log(n))
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        //cut the list in middle
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);
        return mergeTwoLists(l1, l2);
    }

    private ListNode findMid(ListNode head) {
        //We need the previous to middle node
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    /**
     * Time: O(n)
     * Can be done without recursion as well.
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
