package com.demo.leetcode.medium._01_keyandroom_841;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [841. Keys and Rooms - MEDIUM](https://leetcode.com/problems/keys-and-rooms/)
 *
 * - bfs, visited
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=gU8raekRs1E&ab_channel=DEEPTITALESRA
 */
public class KeysAndRoom {

    @Test
    public void test() {
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Collections.emptyList());
        Assertions.assertTrue(canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : rooms.get(i))
                if (!visited.contains(j)) {
                    queue.add(j);
                    visited.add(j);
                    if (rooms.size() == visited.size()) return true;
                }
        }
        return rooms.size() == visited.size();
    }
}
