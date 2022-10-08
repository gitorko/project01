package com.demo.leetcode.medium._03_encodedecodetinyurl_535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [535. Encode and Decode TinyURL - MEDIUM](https://leetcode.com/problems/encode-and-decode-tinyurl/)
 *
 *  - two map, while loop
 *  - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=VyBOaboQLGc&ab_channel=NeetCode
 */
public class EncodeDecodeTinyUrl {

    @Test
    public void test() {
        Codec obj = new Codec();
        String tiny = obj.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(tiny);
        String result = obj.decode(tiny);
        Assertions.assertEquals("https://leetcode.com/problems/design-tinyurl", result);
    }

    class Codec {

        private String alphabets =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private Map<String, String> urlToCode = new HashMap<>();
        private Map<String, String> codeToUrl = new HashMap<>();
        private Random rand = new Random();

        public String encode(String longUrl) {
            //important to do this in while loop as there can be collision
            while (!urlToCode.containsKey(longUrl)) {
                String code = getRandomKey();
                if (!codeToUrl.containsKey(code)) {
                    codeToUrl.put(code, longUrl);
                    urlToCode.put(longUrl, code);
                    return "http://tinyurl.com/" + code;
                }
            }
            throw new IllegalArgumentException();
        }

        public String decode(String shortUrl) {
            return codeToUrl.get(shortUrl.substring(19));
        }

        private String getRandomKey() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                char nextChar = alphabets.charAt(rand.nextInt(alphabets.length()));
                sb.append(nextChar);
            }
            return sb.toString();
        }

    }
}
