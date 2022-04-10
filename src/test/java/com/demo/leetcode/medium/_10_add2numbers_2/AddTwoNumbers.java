package com.demo.leetcode.medium._10_add2numbers_2;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2. Add Two Numbers - EASY](https://leetcode.com/problems/add-two-numbers/)
 *
 * - dummy node
 * - carry, mod 10, divide by 10
 * - SIMILAR_TO: [67. Add Binary - EASY](https://leetcode.com/problems/add-binary/)
 *
 * https://www.youtube.com/watch?v=wgFPrzTjm7s&ab_channel=NeetCode
 */
public class AddTwoNumbers {

    @Test
    public void test() {
        int arr1[] = {2, 4, 3};
        int arr2[] = {5, 6, 4};
        int expected[] = {7, 0, 8};
        ListNode l1 = ListNodeUtil.create(arr1);
        ListNode l2 = ListNodeUtil.create(arr2);
        ListNodeUtil.display(l1);
        ListNodeUtil.display(l2);

        ListNode l3 = addTwoNumbers(l1, l2);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(l3));
        ListNodeUtil.display(l3);
    }

    /**
     * Time: O(max(m, n)). Assume that m and n represents the length of l1 and l2
     * Space: O(max(m,n)).
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * edge case: 7+8=15 (carry of 1) so list 5->1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry % 10);
            carry = carry / 10;
            curr = curr.next;

        }
        return dummy.next;
    }
}
