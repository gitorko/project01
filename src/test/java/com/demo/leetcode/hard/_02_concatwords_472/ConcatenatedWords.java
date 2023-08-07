package com.demo.leetcode.hard._02_concatwords_472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [472. Concatenated Words - HARD](https://leetcode.com/problems/concatenated-words/)
 *
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=iHp7fjw1R28&t=1s&ab_channel=NeetCodeIO
 */
public class ConcatenatedWords {

    @Test
    public void test() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> expected = Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat");
        Assertions.assertEquals(expected, findAllConcatenatedWordsInADict(words));
    }

    HashSet<String> wordSet;
    HashSet<String> nonCombination;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        wordSet = new HashSet<>(Arrays.asList(words));
        nonCombination = new HashSet<>();
        for (String word : words) {
            if (dfs(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean dfs(String word) {
        if (nonCombination.contains(word)) {
            return false;
        }
        //start from 1 to avoid substring(0,0) which is empty
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (wordSet.contains(prefix)) {
                if (wordSet.contains(suffix) || dfs(suffix)) {
                    //caching result by saving the match word to avoid future lookup on similar word.
                    wordSet.add(word);
                    return true;
                }
            }
        }
        //When we know this word will never lead to result add this to non combination set to avoid processing it again
        nonCombination.add(word);
        return false;
    }
}
