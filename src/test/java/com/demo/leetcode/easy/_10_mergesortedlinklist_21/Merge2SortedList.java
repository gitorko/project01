package com.demo.leetcode.easy._10_mergesortedlinklist_21;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [21. Merge Two Sorted Lists - EASY](https://leetcode.com/problems/merge-two-sorted-lists/)
 *
 * - dummy head & start adding to it.
 * - edge case of adding left over elements
 * - SIMILAR_TO: [23. Merge k Sorted Lists - HARD](https://leetcode.com/problems/merge-k-sorted-lists/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=XIdigk956u0&ab_channel=NeetCode
 */
public class Merge2SortedList {

    @Test
    public void test1() {
        int expected[] = {1, 1, 2, 3, 4, 4};
        int arr1[] = {1, 2, 4};
        int arr2[] = {1, 3, 4};
        ListNode r1 = ListNodeUtil.create(arr1);
        ListNode r2 = ListNodeUtil.create(arr2);
        ListNode actual = mergeTwoLists(r1, r2);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(actual));
    }

    @Test
    public void test2() {
        int expected[] = {1};
        int arr1[] = {};
        int arr2[] = {1};
        ListNode r1 = ListNodeUtil.create(arr1);
        ListNode r2 = ListNodeUtil.create(arr2);
        ListNode actual2 = mergeTwoListsIterative(r1, r2);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(actual2));
    }

    /**
     * Iterative - dummy node
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        //remainder list
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    /**
     * Recursive
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
