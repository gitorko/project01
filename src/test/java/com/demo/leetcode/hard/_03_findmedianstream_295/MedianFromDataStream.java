package com.demo.leetcode.hard._03_findmedianstream_295;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [295. Find Median from Data Stream - HARD](https://leetcode.com/problems/find-median-from-data-stream/)
 *
 * - two heap, (max heap, min heap)
 * - SIMILAR_TO: [4. Median of Two Sorted Arrays - HARD](https://leetcode.com/problems/median-of-two-sorted-arrays/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=itmhHWaHupI&ab_channel=NeetCode
 */
public class MedianFromDataStream {

    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        Assertions.assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        Assertions.assertEquals(2.0, medianFinder.findMedian());
    }

    /**
     * adding to heap O(log n), removing is also O(log n), find is O(1)
     */
    class MedianFinder {
        //max heap
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        //min heap
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        boolean even = true;

        public double findMedian() {
            if (even) {
                return (leftHeap.peek() + rightHeap.peek()) / 2.0;
            } else {
                return leftHeap.peek();
            }
        }

        public void addNum(int num) {
            if (even) {
                rightHeap.offer(num);
                leftHeap.offer(rightHeap.poll());
            } else {
                leftHeap.offer(num);
                rightHeap.offer(leftHeap.poll());
            }
            even = !even;
        }
    }
}
