package com.demo.leetcode.medium._10_sortlinklist_148;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [148. Sort List - MEDIUM](https://leetcode.com/problems/sort-list/)
 *
 * - merge sort
 * - mid
 * - merge 2 list
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //cut the list in middle
        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
