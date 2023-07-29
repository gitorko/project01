package com.demo.leetcode.medium._04_seatreservation_1845;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1845. Seat Reservation Manager - MEDIUM](https://leetcode.com/problems/seat-reservation-manager/)
 *
 * - min heap, tracks only unreserved seats
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=ahobllKXEEY&ab_channel=NeetCode
 */
public class SeatReservation {

    @Test
    public void test() {
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        // All seats are available, so return the lowest numbered seat, which is 1.
        Assertions.assertEquals(1, seatManager.reserve());
        // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        Assertions.assertEquals(2, seatManager.reserve());
        // Unreserve seat 2, so now the available seats are [2,3,4,5].
        seatManager.unreserve(2);
        // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        Assertions.assertEquals(2, seatManager.reserve());
        // The available seats are [3,4,5], so return the lowest of them, which is 3.
        Assertions.assertEquals(3, seatManager.reserve());
        // The available seats are [4,5], so return the lowest of them, which is 4.
        Assertions.assertEquals(4, seatManager.reserve());
        // The only available seat is seat 5, so return 5.
        Assertions.assertEquals(5, seatManager.reserve());
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }

    class SeatManager {
        Queue<Integer> minHeap;

        public SeatManager(int n) {
            minHeap = new PriorityQueue();
            for (int i = 1; i < n + 1; i++) {
                minHeap.add(i);
            }
        }

        public int reserve() {
            return minHeap.poll();
        }

        public void unreserve(int seatNumber) {
            minHeap.offer(seatNumber);
        }
    }
}
