package com.demo.leetcode.medium._10_removennodelinklist_19;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [19. Remove Nth Node From End of List - MEDIUM](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
 *
 * - dummy node, two pointer
 * - PRACTICE: P3
 * - MISTAKES: Likely to find length and then iterate instead of using 2 pointers
 *
 * https://www.youtube.com/watch?v=XVuQxVej6y8&ab_channel=NeetCode
 */
public class RemoveNNodeLinkList {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5};
        int expected[] = {1, 2, 3, 5};
        ListNode rootNode = ListNodeUtil.create(arr);
        rootNode = removeNthFromEnd(rootNode, 2);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        //prev will be one node behind the actual node to delete
        ListNode prev = dummy;
        ListNode curr = head;

        //move curr pointer n positions
        while (n > 0 && curr != null) {
            curr = curr.next;
            n--;
        }

        //move both pointers till curr pointer reaches end.
        while (curr != null) {
            prev = prev.next;
            curr = curr.next;
        }

        //delete the desired node
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     * Recursion
     * Time: O(n)
     * Space: O(n)
     */
    int count = 0;

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //base case
        if (head == null) {
            return null;
        }

        head.next = removeNthFromEnd2(head.next, n);
        count++;
        if (count == n) {
            return head.next;
        } else {
            return head;
        }
    }
}
