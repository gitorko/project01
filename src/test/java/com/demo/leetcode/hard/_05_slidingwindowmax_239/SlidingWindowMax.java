package com.demo.leetcode.hard._05_slidingwindowmax_239;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [239. Sliding Window Maximum - HARD](https://leetcode.com/problems/sliding-window-maximum/)
 *
 * - monotonic decreasing dequeue
 * - deque which holds index
 * - brute force: O(k * (n -k))
 *
 * https://www.youtube.com/watch?v=DfljaUwZsOk&ab_channel=NeetCode
 */
public class SlidingWindowMax {

    @Test
    public void test() {
        int nums[] = {8, 7, 6, 9};
        int k = 2;
        int expected[] = {8, 7, 9};
        Assertions.assertArrayEquals(expected, maxSlidingWindow(nums, k));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) {
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offer(right);
            //If left value is out of bound remove it
            if (left > queue.peek()) {
                queue.poll();
            }
            //window is at least size k
            if (right + 1 >= k) {
                result[left] = nums[queue.peek()];
                left++;
            }
        }
        return result;
    }

}
