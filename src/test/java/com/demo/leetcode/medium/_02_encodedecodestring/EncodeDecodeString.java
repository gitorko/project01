package com.demo.leetcode.medium._02_encodedecodestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [271. Encode and Decode Strings - MEDIUM](https://leetcode.com/problems/encode-and-decode-strings/)
 *
 * - https://www.lintcode.com/problem/659/
 * - count and delimiter
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=B1k_sxOSgv8&ab_channel=NeetCode
 */
public class EncodeDecodeString {

    @Test
    public void test1() {
        Codec codec = new Codec();
        String encode = codec.encode(Arrays.asList("lint", "code", "love", "you"));
        List<String> decode = codec.decode(encode);
        Assertions.assertEquals("4/lint4/code4/love3/you", encode);
        Assertions.assertEquals(Arrays.asList("lint", "code", "love", "you"), decode);
    }

    @Test
    public void test2() {
        Codec codec = new Codec();
        String encode = codec.encode(Arrays.asList("lint/", "4code", "love", "you"));
        List<String> decode = codec.decode(encode);
        Assertions.assertEquals("5/lint/5/4code4/love3/you", encode);
        Assertions.assertEquals(Arrays.asList("lint/", "4code", "love", "you"), decode);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    class Codec {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder encoded = new StringBuilder();
            for (String s : strs) {
                encoded.append(s.length()).append('/').append(s);
            }
            return encoded.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> decoded = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int slash = s.indexOf('/', i);
                int length = Integer.parseInt(s.substring(i, slash));
                i = slash + length + 1;
                decoded.add(s.substring(slash + 1, i));
            }
            return decoded;
        }
    }
}
