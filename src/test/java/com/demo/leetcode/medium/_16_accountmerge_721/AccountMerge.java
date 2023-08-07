package com.demo.leetcode.medium._16_accountmerge_721;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [721. Accounts Merge - MEDIUM](https://leetcode.com/problems/accounts-merge/)
 *
 * - bfs
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=6st4IxEF-90&ab_channel=NeetCodeIO
 */
public class AccountMerge {

    @Test
    public void test() {
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> expected = Arrays.asList(Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));

        List<List<String>> actual = accountsMerge(accounts);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * BFS
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String email = account.get(1);
            graph.putIfAbsent(email, new LinkedList<>());
            emailName.put(email, name);
            for (int i = 2; i < account.size(); i++) {
                String newEmail = account.get(i);
                emailName.put(newEmail, name);
                graph.putIfAbsent(newEmail, new LinkedList<>());
                graph.get(newEmail).add(email);
                graph.get(email).add(newEmail);
            }
        }
        List<List<String>> result = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (visited.contains(email)) {
                continue;
            }
            visited.add(email);
            String name = emailName.get(email);
            List<String> emails = new LinkedList<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(email);
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                emails.add(cur);
                for (String next : graph.get(cur)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            Collections.sort(emails);
            emails.add(0, name);
            result.add(emails);
        }
        return result;
    }
}
