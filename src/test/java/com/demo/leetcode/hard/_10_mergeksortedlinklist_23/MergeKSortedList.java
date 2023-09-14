package com.demo.leetcode.hard._10_mergeksortedlinklist_23;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [23. Merge k Sorted Lists - HARD](https://leetcode.com/problems/merge-k-sorted-lists/)
 *
 * - merge sort
 * - merge 2 sorted link list.
 * - SIMILAR_TO: [21. Merge Two Sorted Lists - EASY](https://leetcode.com/problems/merge-two-sorted-lists/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=q5a5OiGbT6Q&ab_channel=NeetCode
 */
public class MergeKSortedList {

    @Test
    public void test1() {
        int expected[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr1[] = {1, 4, 7};
        ListNode r1 = ListNodeUtil.create(arr1);
        int arr2[] = {2, 5, 8};
        ListNode r2 = ListNodeUtil.create(arr2);
        int arr3[] = {3, 6, 9};
        ListNode r3 = ListNodeUtil.create(arr3);
        ListNode[] lists = {r1, r2, r3};
        ListNode actual = mergeKLists(lists);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(actual));
    }

    /**
     * Time: O(n*log(k))
     * Space: O(1)
     */
    ListNode[] lists;

    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(0, lists.length - 1);
    }

    private ListNode mergeKLists(int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (start + end) / 2;
            ListNode leftList = mergeKLists(start, mid);
            ListNode rightList = mergeKLists(mid + 1, end);
            return mergeTwoLists(leftList, rightList);
        } else {
            return null;
        }
    }

    /**
     * Recursive
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
