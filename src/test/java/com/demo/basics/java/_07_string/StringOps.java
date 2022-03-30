package com.demo.basics.java._07_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StringOps {

    @Test
    public void test_reverseString() {
        StringBuilder sb = new StringBuilder("abcdef");
        System.out.println(sb.reverse());
    }

    @Test
    public void test_reverseString2() {
        StringBuilder sb = new StringBuilder("abcdef");
        System.out.println(sb.reverse());
    }

    @Test
    public void test_charToString() {
        char[] t = "fceadb".toCharArray();
        Arrays.sort(t);
        System.out.println(new String(t));
    }

    @Test
    public void test_tokenize() {
        List<String> result = Collections.list(new StringTokenizer("welcome|home|jack", "|")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
