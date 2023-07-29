package com.demo.leetcode.easy._10_palindromelinklist_234;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [234. Palindrome Linked List - EASY](https://leetcode.com/problems/palindrome-linked-list/)
 *
 * - find middle, reverse 2nd half, compare both half
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=yOzXms1J6Nk&ab_channel=NeetCode
 */
public class PalindromeLinkList {

    @Test
    public void test1() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 2, 1));
        Assertions.assertTrue(isPalindrome(root));
    }

    @Test
    public void test2() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 3, 2, 1));
        Assertions.assertTrue(isPalindrome(root));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
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
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }
        ListNode left = head;
        ListNode right = prev;
        //check if palindrome, will handle both even and odd length palindrome
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

}
