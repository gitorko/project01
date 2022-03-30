package com.demo.leetcode.medium._04_seatreservation_1845;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

/**
 * [1845. Seat Reservation Manager - MEDIUM](https://leetcode.com/problems/seat-reservation-manager/)
 *
 * - min heap, tracks only unreserved seats
 *
 * https://www.youtube.com/watch?v=ahobllKXEEY&ab_channel=NeetCode
 */
public class SeatReservation {

    @Test
    public void test() {
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
        seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
        seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
        seatManager.reserve();    // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }

    class SeatManager {
        PriorityQueue<Integer> pq;
        int count;
        int maxSeats;

        public SeatManager(int n) {
            count = 0;
            maxSeats = n;
            pq = new PriorityQueue();
        }

        public int reserve() {
            if (count > maxSeats) return -1;
            if (pq.isEmpty())
                return ++count;

            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }
}
