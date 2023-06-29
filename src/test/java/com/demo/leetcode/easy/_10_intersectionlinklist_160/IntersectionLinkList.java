package com.demo.leetcode.easy._10_intersectionlinklist_160;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [160. Intersection of Two Linked Lists - EASY](https://leetcode.com/problems/intersection-of-two-linked-lists/)
 *
 * - Two pointer - loop 2 times
 * - Reset the pointer to head so the list is iterated twice but time complexity is same.
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=D0X0BONOQhI&ab_channel=NeetCode
 */
public class IntersectionLinkList {

    @Test
    public void test() {

        int arr1[] = {4, 1};
        ListNode r1 = ListNodeUtil.create(arr1);
        int arr2[] = {5, 6, 3};
        ListNode r2 = ListNodeUtil.create(arr2);
        int arr3[] = {8, 7, 9};
        ListNode r3 = ListNodeUtil.create(arr3);
        int arr4[] = {2, 10, 12};
        ListNode r4 = ListNodeUtil.create(arr4);
        ListNode h1 = r1;
        while (h1.next != null) {
            h1 = h1.next;
        }
        h1.next = r3;
        ListNode h2 = r2;
        while (h2.next != null) {
            h2 = h2.next;
        }
        h2.next = r3;
        ListNodeUtil.display(r1);
        ListNodeUtil.display(r2);
        ListNodeUtil.display(r4);

        Assertions.assertEquals(8, getIntersectionNode(r1, r2).getVal());
        Assertions.assertEquals(null, getIntersectionNode2(r1, r4));

        Assertions.assertEquals(8, getIntersectionNode2(r1, r2).getVal());
        Assertions.assertEquals(null, getIntersectionNode2(r1, r4));
    }

    /**
     * Time: O(m + n)
     * Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) {
            return null;
        }

        ListNode l1 = headA;
        ListNode l2 = headB;

        //if l1 & l2 have different len, then we will stop the loop after second iteration
        //if both dont intersect the meet at end (null)
        while (l1 != l2) {
            //for the end of first iteration, we just reset the pointer to the head of another linked list
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    /**
     * Same logic as above, but explained in detail.
     * Two pointer
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        //Move till one pointer reaches the end.
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //assign pointer to starting.
        if (p1 == null) {
            p1 = headB;
        }
        if (p2 == null) {
            p2 = headA;
        }

        //move the other pointer to the end.
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //assign pointer to starting.
        if (p1 == null) {
            p1 = headB;
        }
        if (p2 == null) {
            p2 = headA;
        }

        //final move both pointer to end. If they match then intersection
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
