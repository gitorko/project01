package com.demo.leetcode.medium._03_repeateddnaseq_187;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [187. Repeated DNA Sequences - MEDIUM](https://leetcode.com/problems/repeated-dna-sequences/)
 *
 * - set
 *
 * https://www.youtube.com/watch?v=FzTYfsmtOso&ab_channel=NeetCode
 */
public class RepeatedDnaSeq {

    @Test
    public void test() {
        List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
        Assertions.assertEquals(expected, findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /**
     * Time: O(10n)=O(n)
     * Space: O(10n)=O(n)
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String seq = s.substring(i, i + 10);
            if (seen.contains(seq))
                result.add(seq);
            seen.add(seq);
        }
        return new ArrayList<>(result);
    }
}
