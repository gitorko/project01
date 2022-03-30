package com.demo.leetcode.medium._10_reorderlinklist_143;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [143. Reorder List - MEDIUM](https://leetcode.com/problems/reorder-list/)
 *
 * - find mid, reverse 2nd half, merge
 * - use fast point slow pointer to find middle.
 * - reverse 2nd half of list.
 * - use two pointer to merge 2 list.
 *
 * https://www.youtube.com/watch?v=S5bfdUTrKLM&ab_channel=NeetCode
 */
public class ReorderLinkList {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5};
        int expected[] = {1, 5, 2, 4, 3};
        ListNode rootNode = ListNodeUtil.create(arr);
        reorderList(rootNode);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public void reorderList(ListNode head) {
        //find the middle.
        ListNode midNode = midNode(head);
        //find the second half start
        ListNode nextToMid = midNode.next;
        //break the first half.
        midNode.next = null;
        //reverse the 2nd half.
        ListNode p2 = reverse(nextToMid);

        //merge the 2 lists.
        ListNode p1 = head;
        ListNode temp;
        while (p1 != null && p2 != null) {
            temp = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = temp;
        }
    }

    /**
     * fast pointer slow pointer to find middle.
     */
    private ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //for even length list fast pointer will reach last node.
        //for odd length list fast pointer will reach null node.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Two pointer to reverse the list.
     */
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
