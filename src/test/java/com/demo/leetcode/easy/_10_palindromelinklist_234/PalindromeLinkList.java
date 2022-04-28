package com.demo.leetcode.easy._10_palindromelinklist_234;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [234. Palindrome Linked List - EASY](https://leetcode.com/problems/palindrome-linked-list/)
 *
 * - find middle using fast slow pointer, reverse
 *
 * PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=yOzXms1J6Nk&ab_channel=NeetCode
 */
public class PalindromeLinkList {

    @Test
    public void test() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 2, 1));
        Assertions.assertTrue(isPalindrome(root));
    }

    public boolean isPalindrome(ListNode head) {
        //find middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse 2nd half
        ListNode mid = slow;
        ListNode prev = null;
        while (mid != null) {
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        ListNode l2 = prev;
        ListNode l1 = head;

        //check if palindrome
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

}
