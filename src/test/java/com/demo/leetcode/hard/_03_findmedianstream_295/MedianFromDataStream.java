package com.demo.leetcode.hard._03_findmedianstream_295;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [295. Find Median from Data Stream - HARD](https://leetcode.com/problems/find-median-from-data-stream/)
 *
 * - Two heap, (max heap, min heap)
 * - Heap, Adding to heap O(log N), removing is also O(log N), find is O(1)
 *
 * PRACTICE: P1
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

    class MedianFinder {

        //small is max heap
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        //large is min heap
        PriorityQueue<Integer> large = new PriorityQueue<>();
        boolean even = true;

        public double findMedian() {
            if (even)
                return (small.peek() + large.peek()) / 2.0;
            else
                return small.peek();
        }

        public void addNum(int num) {
            if (even) {
                large.offer(num);
                small.offer(large.poll());
            } else {
                small.offer(num);
                large.offer(small.poll());
            }
            even = !even;
        }
    }
}
