package com.demo.leetcode.hard._16_reconstructitinerary_332;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [332. Reconstruct Itinerary - HARD](https://leetcode.com/problems/reconstruct-itinerary/)
 *
 * - min heap
 * - linked list
 *
 * https://www.youtube.com/watch?v=ZyB_gQ8vqGA&ab_channel=NeetCode
 */
public class ReconstructItinerary {

    @Test
    public void test1() {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO"));
        List<String> expected = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        Assertions.assertEquals(expected, findItinerary(tickets));
    }

    @Test
    public void test2() {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "MUC"),
                Arrays.asList("MUC", "JFK"),
                Arrays.asList("JFK", "SFO"));
        List<String> expected = Arrays.asList("JFK", "MUC", "JFK", "SFO");
        Assertions.assertEquals(expected, findItinerary(tickets));
    }

    @Test
    public void test3() {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "KUL"),
                Arrays.asList("JFK", "NRT"),
                Arrays.asList("NRT", "JFK"));
        List<String> expected = Arrays.asList("JFK", "NRT", "JFK", "KUL");
        Assertions.assertEquals(expected, findItinerary(tickets));
    }

    @Test
    public void test4() {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );
        List<String> expected = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        Assertions.assertEquals(expected, findItinerary(tickets));
    }

    //[source, heap of destination]
    Map<String, Queue<String>> graph;
    LinkedList<String> result;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        return result;
    }

    private void dfs(String u) {
        Queue<String> arrivals = graph.get(u);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        result.addFirst(u);
    }
}
