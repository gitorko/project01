package com.demo.leetcode.medium._25_searchsuggestion_1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * [1268. Search Suggestions System - MEDIUM](https://leetcode.com/problems/search-suggestions-system/)
 *
 * - two pointer
 *
 * https://www.youtube.com/watch?v=D4T2N0yAr20&ab_channel=NeetCode
 */
public class SearchSuggestion {

    @Test
    public void test() {
        String products[] = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> expected = Arrays.asList(Arrays.asList("mobile", "moneypot", "monitor"),
                Arrays.asList("mobile", "moneypot", "monitor"),
                Arrays.asList("mouse", "mousepad"),
                Arrays.asList("mouse", "mousepad"),
                Arrays.asList("mouse", "mousepad"));
        Assertions.assertEquals(expected, suggestedProducts(products, searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int left = 0;
        int right = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }
            int remain = right - left + 1;
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < Math.min(3, remain); j++) {
                tempList.add(products[left + j]);
            }
            res.add(tempList);
        }
        return res;
    }
}
