package com.demo.leetcode.hard._05_slidingwindowmax_239;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [239. Sliding Window Maximum - HARD](https://leetcode.com/problems/sliding-window-maximum/)
 *
 * - monotonic decreasing de-queue, two pointer
 * - deque which holds index
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=DfljaUwZsOk&ab_channel=NeetCode
 */
public class SlidingWindowMax {

    @Test
    public void test1() {
        int nums[] = {8, 7, 6, 9};
        int k = 2;
        int expected[] = {8, 7, 9};
        Assertions.assertArrayEquals(expected, maxSlidingWindow(nums, k));
    }

    @Test
    public void test2() {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int expected[] = {3, 3, 5, 5, 6, 7};
        Assertions.assertArrayEquals(expected, maxSlidingWindow(nums, k));
    }

    @Test
    public void test3() {
        int nums[] = {7, 2, 4};
        int k = 2;
        int expected[] = {7, 4};
        Assertions.assertArrayEquals(expected, maxSlidingWindow(nums, k));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        //dequeue holds index
        Deque<Integer> dequeue = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) {
            // remove smaller numbers in k range as they are useless
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[right]) {
                dequeue.pollLast();
            }
            dequeue.offer(right);
            //confusing part: if left pointer has crossed our left most value in the queue then remove it
            if (left > dequeue.peek()) {
                dequeue.poll();
            }
            //window is size k
            int windowSize = right - left + 1;
            if (windowSize == k) {
                result[left] = nums[dequeue.peek()];
                left++;
            }
        }
        return result;
    }

}
