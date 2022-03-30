package com.demo.leetcode.medium._10_removeduplicates2linklist_82;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [82. Remove Duplicates from Sorted List II - MEDIUM](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
 *
 * - dummy node + two while loop
 *
 * PRACTICE
 */
public class RemoveDuplicatesSortList2 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        int[] expected = {1, 2, 5};
        ListNode head = ListNodeUtil.create(nums);
        ListNode result = deleteDuplicates(head);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(result));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            if (prev.next == head)
                prev = prev.next;
            else
                prev.next = head.next;
            head = head.next;
        }
        return dummy.next;
    }
}
