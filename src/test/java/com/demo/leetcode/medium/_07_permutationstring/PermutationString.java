package com.demo.leetcode.medium._07_permutationstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [String permutation - MEDIUM]()
 *
 * - backtracking
 */
public class PermutationString {

    @Test
    public void test() {
        List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");
        Assertions.assertEquals(expected, permutationBacktracking("ABC"));
    }

    /**
     * Note that there are n! permutations and it requires O(n) time to print a permutation.
     * Time:  O(n*n!)
     * Space: O(n)
     */
    List<String> result;
    boolean[] visited;
    String word;

    private List<String> permutationBacktracking(String input) {
        word = input;
        result = new ArrayList<>();
        visited = new boolean[word.length()];
        backTrack(new ArrayList<>());
        return result;
    }

    private void backTrack(List<String> tempList) {
        if (tempList.size() == word.length()) {
            result.add(String.join("", tempList));
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (visited[i]) continue;
                tempList.add(String.valueOf(word.charAt(i)));
                visited[i] = true;
                backTrack(tempList);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
