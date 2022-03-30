package com.demo.leetcode.easy._10_removeduplicateslinklist_83;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [83. Remove Duplicates from Sorted List - EASY](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
 *
 * - two while loop
 */
public class RemoveDuplicatesSortLinkList {

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        int[] expected = {1, 2};
        ListNode head = ListNodeUtil.create(nums);
        ListNode result = deleteDuplicates(head);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(result));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val)
                curr.next = curr.next.next;
            curr = curr.next;
        }
        return head;
    }
}
