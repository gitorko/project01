package com.demo.leetcode.hard._02_namingcompany_2306;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2306. Naming a Company - HARD](https://leetcode.com/problems/naming-a-company)
 *
 * - hashset
 *
 * https://www.youtube.com/watch?v=NrHpgTScOcY&ab_channel=NeetCodeIO
 */
public class NamingCompany {

    @Test
    public void test() {
        String[] ideas = {"coffee", "donuts", "time", "toffee"};
        Assertions.assertEquals(6, distinctNames(ideas));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public long distinctNames(String[] ideas) {
        Set<String>[] charSet = new HashSet[26];
        for (int i = 0; i < 26; ++i) {
            charSet[i] = new HashSet<>();
        }
        for (String s : ideas) {
            charSet[s.charAt(0) - 'a'].add(s.substring(1));
        }
        long result = 0;
        for (int i = 0; i < 26; ++i)
            for (int j = i + 1; j < 26; ++j) {
                long c1 = 0;
                long c2 = 0;
                for (String c : charSet[i]) {
                    if (!charSet[j].contains(c)) {
                        c1++;
                    }
                }
                for (String c : charSet[j]) {
                    if (!charSet[i].contains(c)) {
                        c2++;
                    }
                }
                result += c1 * c2;
            }
        return result * 2;
    }
}
