package com.demo.leetcode.medium._04_reorganizestring_767;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [767. Reorganize String - MEDIUM](https://leetcode.com/problems/reorganize-string/)
 * [358. Rearrange String k Distance Apart - MEDIUM](https://leetcode.com/problems/rearrange-string-k-distance-apart/)
 *
 * - map + max heap + queue + string builder
 * - SIMILAR_TO: [621. Task Scheduler - MEDIUM](https://leetcode.com/problems/task-scheduler/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=2g_b1aYTHeg&ab_channel=NeetCode
 */
public class ReorganizeString {

    @Test
    public void test() {
        Assertions.assertEquals("aba", reorganizeString("aab"));
        Assertions.assertEquals("", reorganizeString("aaab"));
        Assertions.assertEquals("acaba", reorganizeString("aaabc"));
    }

    /**
     * Time: O(n*log(n))
     * Space O(n + 26)
     */
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        //max heap
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        pq.addAll(charMap.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            //fetch and add to result
            Map.Entry<Character, Integer> entry = pq.poll();
            sb.append(entry.getKey());
            //reduce the count
            entry.setValue(entry.getValue() - 1);
            queue.offer(entry);
            //k value can be changed to make this problem rearrange by k distance
            int k = 1;
            while (queue.size() > k) {
                Map.Entry<Character, Integer> temp = queue.poll();
                if (temp.getValue() > 0) {
                    pq.offer(temp);
                }
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
